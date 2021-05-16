package com.example.demo.service.post;

import com.example.demo.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    Post findById(int theId);

    int save (SavePostRequest request);

    void deleteById(int theId);

}
