package com.example.RedditClone2.repository;

import com.example.RedditClone2.entity.Post;

import java.util.List;

public interface PostDao {
    public  void save(Post post, long userId, long subRedditId);

    List<Post> getPostsBySubRedditId(long subredditId);

    List<Post> getPostsBySubRedditName(String subRedditName);

    Post getPostById(long postId);

    void update(Post post);
}
