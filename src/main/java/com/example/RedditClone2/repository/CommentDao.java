package com.example.RedditClone2.repository;

import com.example.RedditClone2.entity.Comment;

import java.util.List;

public interface CommentDao {
    public void save(Comment comment, long userId, long postId);
    public List<Comment> getCommentsByPostId(long postId);
}
