package com.example.nhom10.Controller;

import com.example.nhom10.DTO.PostDTO;
import com.example.nhom10.DTO.UserDTO;
import com.example.nhom10.entity.Post;
import com.example.nhom10.service.PostService;
import com.example.nhom10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {


    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDTO> getAllUsers() {
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public List<PostDTO> getAllUsersBy(@PathVariable int id) {
        return postService.getPost(id);
    }

    @GetMapping("/user/{userId}")
    public List<Object[]> getPostsByUserId(@PathVariable Integer userId) {
        return postService.getPostsByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post savedPost = postService.savePost(post);
        return ResponseEntity.ok(savedPost);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable int id) {
        return postService.deletePost(id);
    }
    @PutMapping("/{id}")
    public PostDTO updatePost(@PathVariable int id, @RequestBody PostDTO postDTO) {
        return postService.updatePost(id, postDTO);
    }
}
