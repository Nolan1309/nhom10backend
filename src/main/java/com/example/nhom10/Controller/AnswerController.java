package com.example.nhom10.Controller;

import com.example.nhom10.DTO.AnswerDTO;
import com.example.nhom10.DTO.PostDTO;
import com.example.nhom10.entity.Answer;
import com.example.nhom10.entity.Post;
import com.example.nhom10.service.AnswerService;
import com.example.nhom10.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
@CrossOrigin(origins = "http://localhost:3000")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping
    public List<AnswerDTO> getAllUsers() {
        return answerService.getAllAnswers();
    }

    @GetMapping("/{id}")
    public List<AnswerDTO> getAllUsersBy(@PathVariable int id) {
        return answerService.getByAllID(id);
    }

    @PostMapping
    public ResponseEntity<Answer> createPost(@RequestBody Answer answer) {
        Answer savedPost = answerService.saveAnswers(answer);
        return ResponseEntity.ok(savedPost);
    }

}
