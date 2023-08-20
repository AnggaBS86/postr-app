package com.angga.postr.api.services;

import java.util.Map;

public interface IPostService {
    Map<String, Object> findPosts(int pageNo, int pageSize);
}
