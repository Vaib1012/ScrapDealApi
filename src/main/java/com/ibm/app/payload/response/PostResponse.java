package com.ibm.app.payload.response;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.ibm.app.models.Product;
import com.ibm.app.models.User;

public class PostResponse {
	
	private long postId;
	
	private String industryName;

	private Set<Product> productsRequired;

	public PostResponse(long postId, String industryName, Set<Product> productsRequired) {
		super();
		this.postId = postId;
		this.industryName = industryName;
		this.productsRequired = productsRequired;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public Set<Product> getProductsRequired() {
		return productsRequired;
	}

	public void setProductsRequired(Set<Product> productsRequired) {
		this.productsRequired = productsRequired;
	}
	
}
