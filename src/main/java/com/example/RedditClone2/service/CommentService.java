package com.example.RedditClone2.service;

import com.example.RedditClone2.entity.Comment;
import com.example.RedditClone2.repository.CommentDao;
import com.example.RedditClone2.repository.PostDao;
import com.example.RedditClone2.repository.SubRedditDao;
import com.example.RedditClone2.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private CommentDao commentDao;
    private UserDao userDao;
    private PostDao postDao;
    @Autowired
    public CommentService(CommentDao commentDao, UserDao userDao, PostDao postDao) {
        this.commentDao = commentDao;
        this.userDao = userDao;
        this.postDao = postDao;
    }

    public void addComment(Comment comment, long postId) {
        commentDao.save(comment,1,postId);
    }
}
