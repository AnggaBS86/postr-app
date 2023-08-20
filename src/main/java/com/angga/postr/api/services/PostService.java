package com.angga.postr.api.services;

import com.angga.postr.api.entity.Post;
import com.angga.postr.api.entity.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PostService implements IPostService {

    private final PostRepository repository;

    @Autowired
    PostService(PostRepository postRepository) {
        this.repository = postRepository;
    }

    @Override
    public Map<String, Object> findPosts(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Post> pagedResult = repository.findAll(paging);

        Map<String, Object> pagination = new HashMap<>();
        pagination.put("posts", pagedResult.toList());
        pagination.put("page", paging.getPageNumber());
        pagination.put("offset", paging.getOffset());
        pagination.put("total", paging.getPageNumber());
        pagination.put("has_previous", paging.hasPrevious());

        return pagination;
    }
}
