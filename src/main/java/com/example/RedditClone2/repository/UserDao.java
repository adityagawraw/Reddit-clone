package com.example.RedditClone2.repository;

import com.example.RedditClone2.entity.User;

import java.util.List;

public interface UserDao {
    public void save(User user);
    public User getUserById(long userId);
    public void update(User user);
}
