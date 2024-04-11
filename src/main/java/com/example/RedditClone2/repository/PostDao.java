package com.example.RedditClone2.repository;

import com.example.RedditClone2.entity.Post;

public interface PostDao {
    public  void save(Post post, long userId, long subRedditId);
}
