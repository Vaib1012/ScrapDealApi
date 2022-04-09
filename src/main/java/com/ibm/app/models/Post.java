package com.ibm.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="post_id")
	private long postId;
	@Column(name="industry_name")
	private String industryName;

	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
	
	@ManyToMany
	@JoinTable(
	  name = "productslist", 
	  joinColumns = @JoinColumn(name = "post_id"), 
	  inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<Product> productsRequired;

	
	public Post( String industryName, User user, Set<Product> productsRequired) {
		super();
//		this.postId = postId;
		this.industryName = industryName;
		this.user = user;
		this.productsRequired = productsRequired;
	}
	
	public Post(String industryName, User user) {
		super();
//		this.postId = postId;
		this.industryName = industryName;
		this.user = user;
		this.productsRequired = new HashSet<>();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Product> getProductsRequired() {
		return productsRequired;
	}

	public void setProductsRequired(Set<Product> productsRequired) {
		this.productsRequired = productsRequired;
	}
	
	public void addProduct(Product product) {
		productsRequired.add(product);
	}

}
