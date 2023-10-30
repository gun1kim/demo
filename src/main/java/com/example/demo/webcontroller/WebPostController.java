package com.example.demo.webcontroller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class WebPostController {

    private final PostService postService;

    public WebPostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping
    public String posts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts/posts";
    }
    @GetMapping("/{postId}")
    public String post(@PathVariable int postId,  Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "posts/post";
    }

    @GetMapping("/add")
    public String add() {
        return "posts/postForm";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Post post, Model model) {
        Post added = postService.setPost(post);
        model.addAttribute("post", added);
        return "redirect:/posts";
    }

    @GetMapping("/update/{postId}")
    public String update(@PathVariable int postId) {
        return "/posts/update";
    }

    @PostMapping("/update/{postId}")
    public String update(@PathVariable int postId, @ModelAttribute Post post,  Model model) {
        Post updated = postService.getPost(postId);
        updated.setTitle(post.getTitle());
        updated.setBody(post.getBody());
        updated.setLikes(post.getLikes());
        postService.updatePost(postId, updated);
        model.addAttribute("posts", updated);
        return "redirect:/posts";
    }

    @DeleteMapping("/delete/{postId}")
    public String delete(@PathVariable int postId, Model model) {
        postService.deletePost(postId);
        return "redirect:/posts";
    }
}
