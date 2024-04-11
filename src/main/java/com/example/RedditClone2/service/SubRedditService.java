package com.example.RedditClone2.service;

import com.example.RedditClone2.entity.SubReddit;
import com.example.RedditClone2.repository.SubRedditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SubRedditService {
    private SubRedditDao subRedditDao;
    @Autowired
    public SubRedditService(SubRedditDao subRedditDao) {
        this.subRedditDao = subRedditDao;
    }

    public void handleNewSubReddit(SubReddit subReddit){
        String[] rules = subReddit.getRules().get(0).split("\\+");
        subReddit.setRules(Arrays.stream(rules).toList());
        subRedditDao.save(subReddit, 2);
    }
}
