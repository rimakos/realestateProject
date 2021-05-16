package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.service.post.PostService;
import com.example.demo.service.post.SavePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> findAll(){return postService.findAll();}

    @GetMapping("/{postId}")
    public ResponseEntity getPosts(@PathVariable int postId){
        Post post = postService.findById(postId);
        if(post==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        return ResponseEntity.ok(post);
    }
    @PostMapping
    public int addPost(@RequestBody SavePostRequest request){
        return postService.save(request);
    }
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") int id){
        postService.deleteById(id);
    }
}
