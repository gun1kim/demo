package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private static Map<Integer, Post> posts = new HashMap<>();
    private static int seq = 0;

    public PostRepositoryImpl() {
        Post post = new Post();
        post.setPostId(++seq);
        post.setTitle("test1");
        post.setBody("test1");
        post.setLikes(0);
        posts.put(seq, post);
    }

    @Override
    public List<Post> selectAllPosts() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public Post SelectPostById(int postId) {
        Post selected = posts.get(postId);
        return selected;
    }

    @Override
    public Post deletePost(int postId) {
        Post toBeRemoved = posts.remove(postId);
        return toBeRemoved;
    }

    @Override
    public int insertPost(Post post) {
        post.setPostId(++seq);
        posts.put(seq, post);
        return post.getPostId();
    }

    @Override
    public void updatePost(Post post) {
        posts.put(post.getPostId(), post); // 없으면 생성, 있으면 변경

    }
}
