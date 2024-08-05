package com.semicolonafrica.demo.repository;

import com.semicolonafrica.demo.data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CommentRepositoryImplTest {


   @Autowired
   private CommentRepository repository;
   @BeforeEach
   void setUp() {
       repository.deleteAll();
   }

    @Test
    public void testIf_CommentCanBeAdded(){
        Comment comment = new Comment();
        repository.save(comment);
       assertEquals(1,repository.count());
    }

    @Test
    public void testIf_CommentCanFindAll(){
        Comment allComment1 = new Comment();
        Comment allComment2 = new Comment();
        repository.save(allComment1);
        repository.save(allComment2);
        assertEquals(2,repository.count());

    }

    @Test
    public void testIf_CommentsAreEmpty(){
        Comment com = new Comment();
        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    public void testIf_CommentsAreNotEmpty(){
        Comment com1 = new Comment();
        Comment com2 = new Comment();
        repository.save(com1);
        repository.save(com2);
        assertEquals(2,repository.count());
    }

    @Test
    public void testIf_CommentCanBeFindByPost(){
        Comment com1 = new Comment();
        com1.setContent("what just happened");
        repository.save(com1);
        assertEquals(1,repository.count());

    }

    @Test
    public void testIf_CommentCanBeDeletedById(){
        Comment delete1 = new Comment();
        delete1.setContent("what just happened");
        repository.save(delete1);
        repository.deleteById(delete1.getId());
        assertEquals(0,repository.count());

    }

    @Test
    public void testIf_CommentCanUpdate(){
        Comment com1 = new Comment();
        repository.save(com1);
        assertEquals(1,repository.count());


    }

}