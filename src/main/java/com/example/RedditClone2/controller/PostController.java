package com.example.RedditClone2.controller;

import com.example.RedditClone2.entity.Comment;
import com.example.RedditClone2.entity.Post;
import com.example.RedditClone2.entity.SubReddit;
import com.example.RedditClone2.model.PostModel;
import com.example.RedditClone2.repository.CommentDao;
import com.example.RedditClone2.repository.PostDao;
import com.example.RedditClone2.repository.SubRedditDao;
import com.example.RedditClone2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PostController {
    private SubRedditDao subRedditDao;
    private PostService postService;
    private PostDao postDao;
    private CommentDao commentDao;
    @Autowired
    public PostController(SubRedditDao subRedditDao,
                          PostService postService,
                          CommentDao commentDao,
                          PostDao postDao) {
        this.subRedditDao = subRedditDao;
        this.postService = postService;
        this.commentDao = commentDao;
        this.postDao = postDao;
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
        SubReddit subReddit = postService.handleNewPost(postModel);

        return "redirect:/r/"+subReddit.getName();
    }
    @GetMapping("/r/{subRedditName}/{postId}")
    public String getPostPage(Model model,
                              @PathVariable("subRedditName") String subRedditName,
                              @PathVariable("postId") long postId){
        List<Comment> comments = commentDao.getCommentsByPostId(postId);
        Post post = postDao.getPostById(postId);

        model.addAttribute("subRedditName", subRedditName);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());

        return "postPage";
    }
}
