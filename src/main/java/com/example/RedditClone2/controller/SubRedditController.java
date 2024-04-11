package com.example.RedditClone2.controller;

import com.example.RedditClone2.entity.Post;
import com.example.RedditClone2.entity.SubReddit;
import com.example.RedditClone2.repository.PostDao;
import com.example.RedditClone2.service.SubRedditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class SubRedditController {
    private SubRedditService subRedditService;
    private PostDao postDao;
    @Autowired
    public SubRedditController(SubRedditService subRedditService,PostDao postDao) {
        this.subRedditService = subRedditService;
        this.postDao = postDao;
    }

    @GetMapping("/r/{subredditId}")
    public String homePage(Model model,
                           @RequestParam("subredditId") long subredditId){
        List<Post> posts = postDao.getPostsBySubRedditId(subredditId);
        model.addAttribute("date" , new Date());
        return "subRedditHomePage";
    }
    @GetMapping("/createSubReddit")
    public String createNewSubRedditPage(Model model){
        SubReddit subReddit = new SubReddit();
        subReddit.addRule("Enter your Rules to Community");
        model.addAttribute("subReddit", subReddit);
        return "newSubReddit";
    }
    @PostMapping("/processCreateSubReddit")
    public String processCreateSubReddit(@ModelAttribute("subReddit") SubReddit subReddit){
        subRedditService.handleNewSubReddit(subReddit);
    return "subRedditHomePage";
    }
}
