package com.semicolonafrica.demo.controller;

import com.semicolonafrica.demo.data.models.Post;
import com.semicolonafrica.demo.dtos.request.CreatePostRequest;
import com.semicolonafrica.demo.dtos.response.CreatePostResponse;
import com.semicolonafrica.demo.responses.ApiResponse;
import com.semicolonafrica.demo.services.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody  CreatePostRequest request) {
        try{
            CreatePostResponse post = postService.addPost(request);
            return new ResponseEntity<>(new ApiResponse<>(true,post), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse<>(false,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public Post getPost(String postId) {
        Post post = postService.findPostById(postId);
        return post;


    }

}

