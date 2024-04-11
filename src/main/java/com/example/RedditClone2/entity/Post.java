package com.example.RedditClone2.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    @Column(length = 2500)
    private String content;
    @CreationTimestamp
    @Column(name = "created_at" ,updatable = false)
    private String createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private String updatedAt;
    private long upVote;
    private long downVote;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
    @ManyToOne(cascade =
            {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "sub_reddit_id")
    private SubReddit subReddit;
    @ManyToOne(cascade =
            {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getUpVote() {
        return upVote;
    }

    public void setUpVote(long upVote) {
        this.upVote = upVote;
    }

    public long getDownVote() {
        return downVote;
    }

    public void setDownVote(long downVote) {
        this.downVote = downVote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SubReddit getSubReddit() {
        return subReddit;
    }

    public void setSubReddit(SubReddit subReddit) {
        this.subReddit = subReddit;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
