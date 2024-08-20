package com.example.nhom10.DTO;


import java.util.Date;

public class AnswerDTO {
    private int id;
    private String content;
    private Date createAt;
    private int author_id;
    private int post_id;

    public AnswerDTO(int id, String content, Date createAt, int author_id, int post_id) {
        this.id = id;
        this.content = content;
        this.createAt = createAt;
        this.author_id = author_id;
        this.post_id = post_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
}
