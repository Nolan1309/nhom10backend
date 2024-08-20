package com.example.nhom10.DTO;


import java.util.Date;

public class PostDTO {
    private int id;
    private String header;
    private String content;
    private Date createAt;
    private int author_Id;
    private String user_name;
    private String full_name;

    public PostDTO(int id, String header, String content, Date createAt, int author_Id, String full_name, String user_name) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.createAt = createAt;
        this.author_Id = author_Id;
        this.full_name = full_name;
        this.user_name = user_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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

    public int getAuthor_Id() {
        return author_Id;
    }

    public void setAuthor_Id(int author_Id) {
        this.author_Id = author_Id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
