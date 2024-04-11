package com.example.RedditClone2.repository;

import com.example.RedditClone2.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(User user) {
    entityManager.persist(user);
    }

    @Override
    public User getUserById(long id) {
       User user= entityManager.find(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public void update(User user) {
    entityManager.merge(user);
    }
}
