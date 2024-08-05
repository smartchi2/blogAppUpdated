package com.semicolonafrica.demo.repository;

import com.semicolonafrica.demo.data.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
     Post findPostById(String id);






}
