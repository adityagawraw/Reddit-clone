package com.example.RedditClone2.repository;

import com.example.RedditClone2.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl implements PostDao{
    private EntityManager entityManager;
    private UserDao userDao;
    private SubRedditDao subRedditDao;
    @Autowired
    public PostDaoImpl(EntityManager entityManager, UserDao userDao, SubRedditDao subRedditDao){
        this.entityManager = entityManager;
        this.userDao = userDao;
        this.subRedditDao = subRedditDao;
    }
    @Override
    @Transactional
    public void save(Post post, long userId, long subRedditId) {
        post.setUser(userDao.getUserById(userId));
        post.setSubReddit(subRedditDao.getSubRedditById(subRedditId));
        entityManager.persist(post);
    }
}