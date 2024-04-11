package com.example.RedditClone2.repository;

import com.example.RedditClone2.entity.SubReddit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubRedditDaoImpl implements SubRedditDao{
    private EntityManager entityManager;
    private UserDao userDao;
    @Autowired
    public SubRedditDaoImpl(EntityManager entityManager, UserDao userDao){
        this.entityManager = entityManager;
        this.userDao = userDao;
    }
    @Override
    @Transactional
    public void save(SubReddit subReddit, long adminId) {
        subReddit.setAdmin(userDao.getUserById(adminId));
        entityManager.persist(subReddit);
    }

    @Override
    public SubReddit getSubRedditById(long id) {
    return  entityManager.find(SubReddit.class, id);
    }

    @Override
    @Transactional
    public void update(SubReddit subReddit) {
    entityManager.merge(subReddit);
    }

    @Override
    public List<SubReddit> getAllSubReddits() {
        TypedQuery<SubReddit> query = entityManager.createQuery("SELECT sr FROM SubReddit sr", SubReddit.class);
        return query.getResultList();
    }
}
