package com.example.RedditClone2.controller;

import com.example.RedditClone2.entity.SubReddit;
import com.example.RedditClone2.service.SubRedditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class SubRedditController {
    private SubRedditService subRedditService;
    @Autowired
    public SubRedditController(SubRedditService subRedditService) {
        this.subRedditService = subRedditService;
    }

    @GetMapping("/")
    public String homePage(Model model){
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
