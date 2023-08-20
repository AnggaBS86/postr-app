package com.angga.postr.api.services;

import com.angga.postr.api.entity.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PostServicesTest {

    @Autowired
    PostRepository repository;

    @Autowired
    PostService service;

    @Test
    public void testFindPosts() {

        Map<String, Object> postMap = service.findPosts(1, 1);

        System.out.println(postMap.get("posts").toString());
        System.out.println(postMap.get("total").toString());

        assertNotNull(postMap.get("posts"));
        assertEquals(postMap.get("total").toString(), "1");
    }

}
