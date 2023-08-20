package com.angga.postr.api;

import com.angga.postr.api.entity.Comment;
import com.angga.postr.api.entity.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void testFindAll() {
        Comment comment = new Comment();
        comment.setComment("Woke");
        comment.setId(1);
        comment.setUserId(1);
        comment.setPostId(1);

        commentRepository.save(comment);
        List<Comment> comments = commentRepository.findAll();

        assertNotNull(comments);
    }
}
