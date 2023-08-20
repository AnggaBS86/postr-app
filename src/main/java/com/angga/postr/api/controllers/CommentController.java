package com.angga.postr.api.controllers;

import com.angga.postr.api.entity.Comment;
import com.angga.postr.api.entity.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @PostMapping(value = "/comments")
    public Comment create(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }
}
