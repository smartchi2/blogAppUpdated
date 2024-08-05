package com.semicolonafrica.demo.services;

import com.semicolonafrica.demo.data.models.Post;
import com.semicolonafrica.demo.dtos.request.CreatePostRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PostServiceImplTest {

    @Autowired
    private PostServiceImpl postService;


   @Test
   public void testIf_PostCanBeAdded() {
       Post post = new Post();
        post.setTitle("update News");
        post.setContent("bit gist in townn");
       CreatePostRequest createPostRequest = new CreatePostRequest();
       createPostRequest.setTitle("new title");
       createPostRequest.setContent("new content");
        postService.addPost(createPostRequest);
       assertEquals(createPostRequest.getTitle(), "new title");
    }

    @Test
    public void testIf_PostCanBeFindById(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("things are happening");
        createPostRequest.setContent("thing happening");
        Post post = postService.addPost(createPostRequest);
        assertEquals("thing happening",post.getContent());
        assertThat(post.getId()).isNotNull();
    }

    @Test
    public void testIf_PostTitleExistBefore() {
        CreatePostRequest createPostRequest = new CreatePostRequest();
        Post post = new Post();
        createPostRequest.setTitle("update News");
        createPostRequest.setContent("bit gist in twon");
        postService.addPost(createPostRequest);
        assertThat(createPostRequest.getTitle()).isEqualTo("update News");

    }

}