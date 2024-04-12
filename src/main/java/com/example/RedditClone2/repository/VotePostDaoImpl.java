package com.example.RedditClone2.repository;

import com.example.RedditClone2.entity.User;
import com.example.RedditClone2.entity.VotePost;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class VotePostDaoImpl implements VotePostDao{
    private EntityManager entityManager;
    private PostDao postDao;
    private UserDao userDao;
    @Autowired
    public VotePostDaoImpl(EntityManager entityManager, PostDao postDao, UserDao userDao) {
        this.entityManager = entityManager;
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void save(VotePost votePost, long userId, long postId) {
        votePost.setUser(userDao.getUserById(userId));
        votePost.setPost(postDao.getPostById(postId));

        entityManager.persist(votePost);
    }

    @Override
    public VotePost findVotePostByUserIdPostId(long userId, long postId) {
        TypedQuery<VotePost> query =
                entityManager.createQuery("SELECT vp FROM VotePost vp " +
                        "WHERE vp.user.id=:userId AND vp.post.id=:postId", VotePost.class);
        query.setParameter("userId", userId);
        query.setParameter("postId", postId);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(VotePost votePost) {
    entityManager.merge(votePost);
    }
}
