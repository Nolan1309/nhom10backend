package com.example.nhom10.service;

import com.example.nhom10.DTO.AnswerDTO;
import com.example.nhom10.DTO.PostDTO;
import com.example.nhom10.dao.AnswerRepository;
import com.example.nhom10.entity.Answer;
import com.example.nhom10.entity.Post;
import com.example.nhom10.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    public Answer saveAnswers(Answer post)
    {
        return answerRepository.save(post);
    }

    public List<AnswerDTO> getAllAnswers() {
        List<Answer> postList = answerRepository.findAll();
        List<AnswerDTO> postDTOList = postList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return postDTOList;
    }

    public List<AnswerDTO> getByAllID(int id) {
        List<Object[]> postList = answerRepository.findByAllID(id);
        List<AnswerDTO> postDTOList = postList.stream()
                .map(this::convertToDTOObject)
                .collect(Collectors.toList());
        return postDTOList;
    }



    private AnswerDTO convertToDTOObject(Object[] post) {
        int id = (Integer) post[0];
        String content = (String) post[1];
        Date createAt = (Date) post[2];
        int authorId = (Integer) post[3];
        int post_id = (Integer) post[4];
        return new AnswerDTO(id, content, createAt, authorId, post_id);
    }


    private AnswerDTO convertToDTO(Answer answer) {
        User user = answer.getAuthor();
        Post post= answer.getPost();
        return new AnswerDTO(answer.getId(), answer.getContent(), answer.getCreateAt(), user.getId(),post.getId() );
    }
}
