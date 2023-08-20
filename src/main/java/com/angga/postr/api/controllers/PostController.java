package com.angga.postr.api.controllers;

import com.angga.postr.api.entity.Post;
import com.angga.postr.api.entity.PostRepository;
import com.angga.postr.api.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    private IPostService postService;

    @RequestMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAll(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "3") int offset) {
        return new ResponseEntity<>(postService.findPosts(page, offset), HttpStatus.OK);
    }

    @PostMapping(value = "/posts")
    public Post save(@RequestBody Post post) {
        return postRepository.save(post);
    }
}
