package com.example.demo.service.post;

import com.example.demo.dao.PostRepository;
import com.example.demo.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(int theId) {
        return postRepository.findById(theId).orElse(null);
    }

    @Override
    public int save(SavePostRequest request) {
        var dbPost = postRepository.findById(request.getId());
        if(dbPost.isPresent()){
            dbPost.get().setTitle(request.getTitle());
            dbPost.get().setDescription(request.getDescription());
            dbPost.get().setPhoto(request.getPhoto());
            postRepository.save(dbPost.get());
            return dbPost.get().getId();
        }
        var newPost = Post.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .createdAt(new Date())
                .photo(request.getPhoto())
                .build();
        postRepository.save(newPost);
        return newPost.getId();
    }

    @Override
    public void deleteById(int theId) {
        Post post = postRepository.findById(theId).orElseThrow(()-> new IllegalArgumentException());
        postRepository.delete(post);
    }
}
