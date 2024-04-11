package com.example.RedditClone2.service;

import com.example.RedditClone2.entity.Post;
import com.example.RedditClone2.entity.SubReddit;
import com.example.RedditClone2.model.PostModel;
import com.example.RedditClone2.repository.PostDao;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostDao postDao;

    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public SubReddit handleNewPost(PostModel postModel){
        Post post = new Post();
        post.setTitle(postModel.getTitle());
        post.setContent(postModel.getContent());

        postDao.save(post, 2, postModel.getSubRedditId());
        return post.getSubReddit();
    }
}
