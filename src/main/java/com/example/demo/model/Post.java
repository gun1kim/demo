package com.example.demo.model;

import lombok.Data;

@Data
public class Post {
    private int postId;
    private String title;
    private String body;
    private Integer likes;

    public Post() {
        likes = 0;
    }
}
