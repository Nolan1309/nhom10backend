package com.example.nhom10.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(name = "role", nullable = false, length = 50)
    private String role;

//    @OneToMany(mappedBy = "author")
//    private Set<Post> posts;
//
//    @OneToMany(mappedBy = "author")
//    private Set<Answer> answers;
}
