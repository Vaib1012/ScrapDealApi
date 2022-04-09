package com.ibm.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private long productId;
	
	@Column(name="product_name")
	private String productName;
//	
//	@Column(name="product_type")
//	private String productType;
	
	@Column(name="amountperkg")
	private double amountPerKg;

	@Column(name="product_img")
	private String productImgLink;
	
	@ManyToMany(mappedBy = "productsRequired")
	Set<Post> addedByPosts;

	public Product(String productName, double amountPerKg, String productImgLink) {
		super();
		
		this.productName = productName;
//		this.productType = productType;
		this.amountPerKg = amountPerKg;
		this.productImgLink = productImgLink;
		this.addedByPosts = new HashSet<>();
	}
	
	
	public Product( String productName,  double amountPerKg, String productImgLink,
			Set<Post> addedByPosts) {
		super();
		
		this.productName = productName;
//		this.productType = productType;
		this.amountPerKg = amountPerKg;
		this.productImgLink = productImgLink;
		this.addedByPosts = addedByPosts;
	}



	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

//	public String getProductType() {
//		return productType;
//	}
//
//	public void setProductType(String productType) {
//		this.productType = productType;
//	}

	public double getAmountPerKg() {
		return amountPerKg;
	}

	public void setAmountPerKg(double amountPerKg) {
		this.amountPerKg = amountPerKg;
	}

	public String getProductImgLink() {
		return productImgLink;
	}

	public void setProductImgLink(String productImgLink) {
		this.productImgLink = productImgLink;
	}
	
}
