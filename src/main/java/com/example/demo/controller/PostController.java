package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> viewAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/posts")
    public Post registPost(@RequestBody Post post) {
        postService.setPost(post);
        return post;
    }
    @GetMapping("/posts/{postId}")
    public Post getPost(@PathVariable("postId") int postId) {
        System.out.println(postId);
        Post post = postService.getPost(postId);
        return post;
    }

    @PutMapping("/posts/{postId}")
    public Post updatePost(@PathVariable("postId") int postId, @RequestBody Post post) {
        Post toBeUpdated = postService.getPost(postId);
        postService.updatePost(postId, post);

        return toBeUpdated;
    }

    @DeleteMapping("/posts/{postId}")
    public Post deletePost(@PathVariable("postId") int postId) {
        Post toBeDeleted = postService.deletePost(postId);
        return toBeDeleted;
    }
}
