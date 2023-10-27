package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.selectAllPosts();
    }
    public Post getPost(int postId) {
        return postRepository.SelectPostById(postId);
    }

    public Post setPost(Post post) {

        postRepository.insertPost(post);
//        postRepository.selectPostById();
        return post;
    }

    public Post updatePost(int postId, Post post) {
//        postRepository.selectById();
        Post origin = postRepository.SelectPostById(postId);
        origin.setTitle(post.getTitle());
        origin.setBody(post.getBody());
        origin.setLikes(post.getLikes());
//        postRepository.updatePost(post);
        return post;
    }

    public Post deletePost(int postId) {
        Post toBeDeleted = postRepository.deletePost(postId);
        return toBeDeleted;
    }


}
