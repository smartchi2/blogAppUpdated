package com.semicolonafrica.demo.services;

import com.semicolonafrica.demo.data.models.Post;
import com.semicolonafrica.demo.dtos.request.CreatePostRequest;
import com.semicolonafrica.demo.dtos.response.CreatePostResponse;


public interface PostService {
    CreatePostResponse addPost(CreatePostRequest request);
    Post findPostById(String id);
    boolean postExists(String title);

}
