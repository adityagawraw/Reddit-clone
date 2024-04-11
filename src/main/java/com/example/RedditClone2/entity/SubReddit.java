package com.example.RedditClone2.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SubReddit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String name;
    private String description;
    private int dailyLimit;
    private List<String> rules;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private User admin;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "subreddit_subscriber",
            joinColumns = @JoinColumn(name = "subreddit_id"),
            inverseJoinColumns = @JoinColumn(name = "subscriber_id")
    )
    List<User> subscribers;
    @OneToMany(mappedBy = "subReddit")
    private List<Post> posts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(int dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public List<String> getRules() {
        return rules;
    }

    public void setRules(List<String> rules) {
        this.rules = rules;
    }
    public void addRule(String rule){
        if(rules ==null){
            rules = new ArrayList<>();
        }
        rules.add(rule);
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public List<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }
    public void addSubscribers(User user){
        if(subscribers == null){
            subscribers = new ArrayList<>();
        }
        subscribers.add(user);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    public void addPosts(Post post){
        if(posts == null){
            posts = new ArrayList<>();
        }
        posts.add(post);
    }
}
