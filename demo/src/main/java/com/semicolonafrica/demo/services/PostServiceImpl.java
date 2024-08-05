package com.semicolonafrica.demo.services;

import com.semicolonafrica.demo.data.models.Post;
import com.semicolonafrica.demo.dtos.request.CreatePostRequest;
import com.semicolonafrica.demo.dtos.response.CreatePostResponse;
import com.semicolonafrica.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
   private  PostRepository repository;

    @Override
    public CreatePostResponse addPost(CreatePostRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        Post newPost = repository.save(post);
        CreatePostResponse response = new CreatePostResponse();
        response.setId(newPost.getId());
        response.setTitle(newPost.getTitle());
        response.setContent(newPost.getContent());
        return response;

    }

    @Override
    public Post findPostById(String id) {
        return repository.findPostById(id);

    }



    @Override
    public boolean postExists(String title) {
        for (Post post : repository.findAll()) {
            if (post.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }



}
