package com.ibm.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ibm.app.models.Post;
import com.ibm.app.models.User;
import com.ibm.app.payload.response.PostResponse;
import com.ibm.app.repository.PostRepository;
import com.ibm.app.repository.UserRepository;

@Service
public class PostServiceImpl {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PostRepository postRepository;
	
	public void savePost(Post post,String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		post.setUser(user);
		postRepository.save(post);
	}

	//returns list of stocks along with the time-stamps in a user's watchlist
	public List<PostResponse> retrievePosts(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		//Set<Stock> stocks = user.getSavedStocks();
		Set<Post> posts = postRepository.findProductListByUserId(user.getId());
		List<PostResponse>  prodList= new ArrayList<>();
		
		for (Post s : posts) {
			PostResponse postResponse=new PostResponse(s.getPostId(), s.getIndustryName(), s.getProductsRequired());
			prodList.add(postResponse);
		}
		return prodList;
	}
	
	public List<PostResponse> retrieveAllPosts() {
		
		List<Post> posts = postRepository.findAll();
		List<PostResponse>  prodList= new ArrayList<>();
		
		for (Post s : posts) {
			PostResponse postResponse=new PostResponse(s.getPostId(), s.getIndustryName(), s.getProductsRequired());
			prodList.add(postResponse);
		}
		return prodList;
	}
	
}

