package com.semicolonafrica.demo.repository;

import com.semicolonafrica.demo.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
  Comment findCommentById(String id);
}
