package com.example.RedditClone2.repository;

import com.example.RedditClone2.entity.VotePost;

public interface VotePostDao {

    void save(VotePost votePost, long userId, long postId);
    VotePost findVotePostByUserIdPostId(long userId, long postId);

    void update(VotePost votePost);
}
