package com.example.RedditClone2;

import com.example.RedditClone2.entity.Comment;
import com.example.RedditClone2.entity.Post;
import com.example.RedditClone2.entity.SubReddit;
import com.example.RedditClone2.entity.User;
import com.example.RedditClone2.repository.CommentDao;
import com.example.RedditClone2.repository.PostDao;
import com.example.RedditClone2.repository.SubRedditDao;
import com.example.RedditClone2.repository.UserDao;
import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RedditClone2Application {

	public static void main(String[] args) {
		SpringApplication.run(RedditClone2Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDao userDAO,
											   PostDao postDao,
											   SubRedditDao subRedditDao,
											   CommentDao commentDao
	){
		return runner->{
			System.out.println("runner");
//			saveUser(userDAO);
//			savePost( postDao, userDAO);
//			getPosts(userDAO);
//			getPostsPerUser(userDAO);
//			addSubReddit(subRedditDao, userDAO);
//			addSubscribersToSubReddit(subRedditDao, userDAO);
//			getallSubReddits(subRedditDao);
//			getPostsBySubReDID(postDao);
//			addComment(commentDao);
//			getCommentsOfPost(commentDao);
		};
	}

	private void getCommentsOfPost(CommentDao commentDao) {
		List<Comment> comments = commentDao.getCommentsByPostId(1);
		for (Comment post :comments){
			System.out.println(post);
		}
	}

	private void addComment(CommentDao commentDao) {
		Comment comment = new Comment();
		comment.setComment("Probably The meaning of Half means that only Half Roti is left for Mom to eat\n" +
				"\n" +
				"She fed all the rotis to her family and only half is left, showing the love and care about family");
		commentDao.save(comment, 2, 1);
	}

	private void getPostsBySubReDID(PostDao postDao) {
		List<Post> posts = postDao.getPostsBySubRedditId(5);
		for (Post post :posts){
			System.out.println(post);
		}
	}

	private void getallSubReddits(SubRedditDao subRedditDao) {
		List<SubReddit> subRedditList = subRedditDao.getAllSubReddits();
		for(SubReddit subReddit : subRedditList){
			System.out.println(subReddit.getName());
		}
	}

	private void addSubscribersToSubReddit(SubRedditDao subRedditDao, UserDao userDAO) {
		SubReddit subReddit = subRedditDao.getSubRedditById(1);
		User user = userDAO.getUserById(2);
		subReddit.addSubscribers(user);
		System.out.println(subReddit.getSubscribers().size());

		subRedditDao.update(subReddit);
		}

	private void addSubReddit(SubRedditDao subRedditDao, UserDao userDAO) {
		SubReddit subReddit = new SubReddit();
		subReddit.setName("demo1");

		subRedditDao.save(subReddit, 2);
	}

	private void getPosts(UserDao userDAO) {
		User user = userDAO.getUserById(2);
		System.out.println(user.getPosts().size());
	}

	private void savePost(PostDao postDao, UserDao userDAO) {
		User user = userDAO.getUserById(1);
		Post post = new Post();
		post.setTitle(" 3 post");
		post.setContent("no content");
//		post.setUser(user);
		postDao.save(post, 2, 5);
	}

	public void saveUser(UserDao userDAO){
		User user = new User();
		user.setEmail("admin3@reddit.com");
		user.setUsername("admin3");
		user.setPassword("admin3");
		userDAO.save(user);
		System.out.println("hello");
	}
}
