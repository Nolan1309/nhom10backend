package com.example.nhom10.dao;

import com.example.nhom10.DTO.PostDTO;
import com.example.nhom10.DTO.PostWithNameDTO;
import com.example.nhom10.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "posts")
public interface PostRepository extends JpaRepository<Post,Integer> {
    @Query(value = "SELECT pt.* , uc.full_name,uc.username FROM posts pt INNER JOIN users uc ON pt.author_id = uc.id ",nativeQuery = true)
    List<Object[]> getAll();

    @Query(value = "SELECT pt.* , uc.full_name,uc.username FROM posts pt INNER JOIN users uc ON pt.author_id = uc.id WHERE pt.id = :id",nativeQuery = true)
    List<Object[]> getByID(@Param("id") int id);


    @Query(value = "SELECT pt.*, uc.full_name, uc.username " +
            "FROM posts pt " +
            "INNER JOIN users uc ON pt.author_id = uc.id " +
            "WHERE uc.id = :id",
            nativeQuery = true)
    List<Object[]> findPostsByUserId(@Param("id") Integer userId);
}
