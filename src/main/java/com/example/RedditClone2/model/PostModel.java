package com.example.RedditClone2.model;


public class PostModel {
    private String title;
    private String content;
    private  long subRedditId;

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

    public long getSubRedditId() {
        return subRedditId;
    }

    public void setSubRedditId(long subRedditId) {
        this.subRedditId = subRedditId;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", subRedditId=" + subRedditId +
                '}';
    }
}
