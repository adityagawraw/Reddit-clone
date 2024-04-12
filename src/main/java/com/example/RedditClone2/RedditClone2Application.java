package com.example.RedditClone2;

import com.example.RedditClone2.entity.*;
import com.example.RedditClone2.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;

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
											   CommentDao commentDao,
											   VotePostDao votePostDao
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
//			addUpVotePost(votePostDao, postDao);
//			addDownVotePost(votePostDao, postDao);
			changeVoteOFPost(votePostDao, postDao);
		};
	}


	private void changeVoteOFPost(VotePostDao votePostDao, PostDao postDao) {
		VotePost votePost;
		try{
			votePost = votePostDao.findVotePostByUserIdPostId(1, 1);
			Post post = postDao.getPostById(1);
			System.out.println(votePost);

			//		boolean vote = true;
//
//		if(vote){
//			if(votePost.isUpVote()){
//				votePost.setUpVote(false);
//				post.setUpVote(post.getUpVote()-1);
//			}
//			else{
//				votePost.setUpVote(true);
//				votePost.setDownVote(false);
//				post.setUpVote(post.getUpVote()+1);
//				post.setDownVote(post.getDownVote()-1);
//			}
//        }
//		else{
//			if(votePost.isDownVote()){
//				votePost.setDownVote(false);
//				post.setDownVote(post.getDownVote()-1);
//			}
//			else{
//				votePost.setDownVote(true);
//				votePost.setUpVote(false);
//				post.setDownVote(post.getDownVote()+1);
//				post.setUpVote(post.getUpVote()-1);
//			}
//        }
//        votePostDao.update(votePost);
//        postDao.update(post);
		}
		catch (EmptyResultDataAccessException e){
			System.out.println("vote post null for userid");;
		}
    }
	private void addDownVotePost(VotePostDao votePostDao, PostDao postDao) {
		VotePost votePost = new VotePost();
		votePost.setUpVote(false);
		votePost.setDownVote(true);
		votePostDao.save(votePost, 1, 1);

		Post post = postDao.getPostById(1);
		post.setDownVote(post.getDownVote()+1);

		postDao.update(post);
	}

	private void addUpVotePost(VotePostDao votePostDao, PostDao postDao) {
		VotePost votePost = new VotePost();
		votePost.setUpVote(true);
		votePost.setDownVote(false);
		votePostDao.save(votePost, 1, 1);

		Post post = postDao.getPostById(1);
		post.setUpVote(post.getUpVote()+1);

		postDao.update(post);
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
