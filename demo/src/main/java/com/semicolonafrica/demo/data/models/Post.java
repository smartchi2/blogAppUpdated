package com.semicolonafrica.demo.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Document
@Data
public class Post {
    private String id;
    private String title;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
    private List<Comment> comments = new ArrayList<>();
}
