package com.example.RedditClone2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @PostMapping("/addComment")
    public String addNewComment(Model model){
        return "redirect:/r/{subreddit}/{postId}";
    }
}
