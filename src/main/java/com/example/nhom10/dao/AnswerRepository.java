package com.example.nhom10.dao;

import com.example.nhom10.DTO.AnswerDTO;
import com.example.nhom10.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Objects;

@RepositoryRestResource(path = "answers")
public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    @Query(value = "SELECT * FROM answers WHERE post_id = :id",nativeQuery = true)
    List<Object[]> findByAllID(@Param("id") Integer id);
}
