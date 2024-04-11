package com.example.RedditClone2.controller;

import com.example.RedditClone2.entity.Comment;
import com.example.RedditClone2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/addComment/{subRedditName}/{postId}")
    public String addNewComment(Model model,
                                @ModelAttribute("comment") Comment comment,
                                @PathVariable("subRedditName") String subRedditName,
                                @PathVariable("postId") long postId){
        commentService.addComment(comment, postId);

        return "redirect:/r/"+subRedditName+"/"+postId;
    }
}
