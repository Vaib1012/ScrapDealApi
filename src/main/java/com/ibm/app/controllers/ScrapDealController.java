package com.ibm.app.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.app.models.Product;
import com.ibm.app.payload.request.DeleteStockRequest;
import com.ibm.app.payload.request.ProductRequest;
import com.ibm.app.payload.request.RetriveProductByTypeRequest;
import com.ibm.app.payload.request.StockRequest;
import com.ibm.app.payload.response.MessageResponse;
import com.ibm.app.payload.response.PostResponse;
import com.ibm.app.payload.response.ProductResponse;
import com.ibm.app.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/androidapp")
public class ScrapDealController {
	@Autowired
	private ProductServiceImpl productService;

	@Autowired
	private PostServiceImpl postService; 

	
	@PostMapping("/addProduct")
	public ResponseEntity saveStock(@Valid @RequestBody ProductRequest request) {

		productService.addProduct(new Product(request.getProductName(),
				request.getAmountPerKg(),request.getProductImgLink()));
		return ResponseEntity.ok(new MessageResponse("Product added"));
	}


	@PostMapping("/retrieveAllProducts")
	public ResponseEntity<List<ProductResponse>> getAllProducts() {

		List<ProductResponse> productList = productService.retrieveAll();

		return ResponseEntity.ok(productList);
	}

//	@PostMapping("/retrieveProductsByType")
//	public ResponseEntity<List<ProductResponse>> getProductsByType(@Valid @RequestBody RetriveProductByTypeRequest request) {
//
//		List<ProductResponse> productList = productService.retrieveProductsByType(request.getProductType());
//
//		return ResponseEntity.ok(productList);
//	}

	@PostMapping("/retrieveAllPosts")
	public ResponseEntity<List<PostResponse>> getAllPosts() {

		List<PostResponse> postList = postService.retrieveAllPosts();

		return ResponseEntity.ok(postList);
	}
	
	@PostMapping("/retrievePostsOfUser")
	public ResponseEntity<List<PostResponse>> getPostsOfUser() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String username = userDetails.getUsername();

		List<PostResponse> postList = postService.retrievePosts(username);

		return ResponseEntity.ok(postList);
	}
	
	@PostMapping("/addProductsInPost")
	public ResponseEntity<List<PostResponse>> addProductsInPost() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String username = userDetails.getUsername();

		List<PostResponse> postList = postService.retrievePosts(username);

		return ResponseEntity.ok(postList);
	}
	

}