package com.example.nhom10.service;


import com.example.nhom10.DTO.PostDTO;
import com.example.nhom10.DTO.UserDTO;
import com.example.nhom10.dao.PostRepository;
import com.example.nhom10.entity.Post;
import com.example.nhom10.entity.User;
import com.example.nhom10.dao.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Post savePost(Post post)
    {
        return postRepository.save(post);
    }
    @Autowired
    private UserRepository userRepository;
    @Transactional
    public ResponseEntity<String> deletePost(int id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            postRepository.delete(post.get());
            return ResponseEntity.ok("Successful");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

    public List<PostDTO> getAllPost() {
        List<Object[]> postList = postRepository.getAll();
        List<PostDTO> postDTOList = postList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return postDTOList;
    }

    public List<PostDTO>  getPost(int id) {
        List<Object[]> postList = postRepository.getByID(id);
        List<PostDTO> postDTOList = postList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return postDTOList;
    }

    public List<Object[]> getPostsByUserId(Integer userId) {
        return postRepository.findPostsByUserId(userId);
    }

    // Chuyển đổi từ Object[] sang PostDTO
    private PostDTO convertToDTO(Object[] post) {
        int id = (Integer) post[0];
        String content = (String) post[1];
        Date createAt = (Date) post[2];
        String header = (String) post[3];
        int authorId = (Integer) post[4];
        String fullName = (String) post[5];
        String userName = (String) post[6];
        return new PostDTO(id, header, content, createAt, authorId, fullName, userName);
    }
    public PostDTO updatePost(int id, PostDTO postDTO) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        User author = userRepository.findById(postDTO.getAuthor_Id())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        post.setHeader(postDTO.getHeader());
        post.setContent(postDTO.getContent());
        post.setCreateAt(postDTO.getCreateAt());
        post.setAuthor(author);

        Post updatedPost = postRepository.save(post);

        return new PostDTO(
                updatedPost.getId(),
                updatedPost.getHeader(),
                updatedPost.getContent(),
                updatedPost.getCreateAt(),
                updatedPost.getAuthor().getId(),
                updatedPost.getAuthor().getFullName(),
                updatedPost.getAuthor().getUsername()
        );
    }

}

