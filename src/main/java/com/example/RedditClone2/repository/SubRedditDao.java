package com.example.RedditClone2.repository;

import com.example.RedditClone2.entity.SubReddit;

import java.util.List;

public interface SubRedditDao {
    public void save(SubReddit subReddit, long adminId);
    public SubReddit getSubRedditById(long id);
    public void update(SubReddit subReddit);
    public List<SubReddit> getAllSubReddits();
}
