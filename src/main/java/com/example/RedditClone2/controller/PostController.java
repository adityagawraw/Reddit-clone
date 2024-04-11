package com.example.RedditClone2.controller;

import com.example.RedditClone2.entity.Post;
import com.example.RedditClone2.entity.SubReddit;
import com.example.RedditClone2.model.PostModel;
import com.example.RedditClone2.repository.SubRedditDao;
import com.example.RedditClone2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {
    private SubRedditDao subRedditDao;
    private PostService postService;

    @Autowired
    public PostController(SubRedditDao subRedditDao, PostService postService) {
        this.subRedditDao = subRedditDao;
        this.postService = postService;
    }

    @GetMapping("/createPost")
    public String createNewPostPage(Model model){
        List<SubReddit> subReddits = subRedditDao.getAllSubReddits();
        model.addAttribute("subreddits", subReddits);
        model.addAttribute("post", new PostModel());
        return  "createPost";
    }

    @PostMapping("/handleNewPost")
    public String handleNewPost(@ModelAttribute("post") PostModel postModel){
          long subRedditId = postService.handleNewPost(postModel);
        return "redirect: /r/"+subRedditId;
    }
}
