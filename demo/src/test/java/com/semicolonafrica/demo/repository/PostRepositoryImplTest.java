package com.semicolonafrica.demo.repository;

import com.semicolonafrica.demo.data.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PostRepositoryImplTest {
    @Autowired
    private PostRepository repository;

    @BeforeEach
    public void setUp() {
        repository.deleteAll();
    }

    @Test
    public void testIf_postCanBeAdd() {
        Post posts1 = new Post();
        posts1.setTitle("latest protest news");
        posts1.setContent("police men are holding gun");
        repository.save(posts1);
        assertEquals(1,repository.count());

    }

    @Test
    public void testIf_postCanFindById() {
        Post post1 = new Post();
        post1.setContent("police men are");

        repository.save(post1);
        assertEquals(1,repository.count(),3);
    }

    @Test
    public void testIf_postCanBeDeletedAll() {
        Post post1 = new Post();
        post1.setContent("police men are");
        repository.deleteAll();
        assertEquals(0,repository.count());
    }

    @Test
    public void testIf_postCanBeDeletedById() {
        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();
        repository.saveAll(List.of(post3,post2,post1));

        assertEquals(3,repository.count());
    }



}