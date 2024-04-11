package com.example.RedditClone2.repository;

import com.example.RedditClone2.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Post> getPostsBySubRedditId(long subredditId) {
        TypedQuery<Post> query = entityManager.createQuery(
                "SELECT p FROM Post p WHERE p.subReddit.id = :subredditId",
                        Post.class);
        query.setParameter("subredditId", subredditId);

        return query.getResultList();
    }

    @Override
    public List<Post> getPostsBySubRedditName(String subRedditName) {
        TypedQuery<Post> query = entityManager.createQuery(
                "SELECT p FROM Post p WHERE p.subReddit.name = :subRedditName",
                Post.class);
        query.setParameter("subRedditName", subRedditName);

        return query.getResultList();
    }

    @Override
    public Post getPostById(long postId) {
        return entityManager.find(Post.class, postId);
    }
}
