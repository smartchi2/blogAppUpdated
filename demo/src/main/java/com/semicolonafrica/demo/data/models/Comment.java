package com.semicolonafrica.demo.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
@Data
public class Comment {
    private String id;
    private int userId;
    private String content;
    private LocalDateTime createdAt =  LocalDateTime.now();



}
