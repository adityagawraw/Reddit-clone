package com.example.RedditClone2.repository;

import com.example.RedditClone2.entity.Comment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao{
    private EntityManager entityManager;
    private UserDao userDao;
    private PostDao postDao;

    public CommentDaoImpl(EntityManager entityManager, UserDao userDao, PostDao postDao) {
        this.entityManager = entityManager;
        this.userDao = userDao;
        this.postDao = postDao;
    }

    @Override
    @Transactional
    public void save(Comment comment, long userId, long postId) {
        comment.setUser(userDao.getUserById(userId));
        comment.setPost(postDao.getPostById(postId));

        entityManager.persist(comment);
    }

    @Override
    public List<Comment> getCommentsByPostId(long postId) {
        TypedQuery<Comment> query =
                entityManager.createQuery("SELECT c FROM Comment c WHERE c.post.id=:postId", Comment.class);
        query.setParameter("postId", postId);

        return query.getResultList();
    }

}
