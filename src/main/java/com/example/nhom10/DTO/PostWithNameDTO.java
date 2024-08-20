package com.example.nhom10.DTO;

import java.util.Date;

public class PostWithNameDTO {
    private int id;
    private String header;
    private String content;
    private Date createAt;
    private int authorId;
    private String fullName;
    private String userName;

    public PostWithNameDTO(int id, String header, String content, Date createAt, int authorId, String fullName, String userName) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.createAt = createAt;
        this.authorId = authorId;
        this.fullName = fullName;
        this.userName = userName;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
