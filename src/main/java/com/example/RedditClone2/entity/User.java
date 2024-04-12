package com.example.RedditClone2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String email;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    @OneToMany(mappedBy = "user")
    List<Post> posts;
    @OneToMany(mappedBy = "user")
    List<VotePost> votePosts;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "subreddit_subscriber",
            inverseJoinColumns = @JoinColumn(name = "subreddit_id"),
            joinColumns = @JoinColumn(name = "subscriber_id")
    )
    List<SubReddit> subreddits;

    public List<VotePost> getVotePosts() {
        return votePosts;
    }

    public void setVotePosts(List<VotePost> votePosts) {
        this.votePosts = votePosts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<SubReddit> getSubreddits() {
        return subreddits;
    }

    public void setSubreddits(List<SubReddit> subreddits) {
        this.subreddits = subreddits;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
