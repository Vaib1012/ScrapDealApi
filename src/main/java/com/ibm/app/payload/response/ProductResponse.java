package com.ibm.app.payload.response;

public class ProductResponse {

	private long productId;

	private String productName;
	
//	private String productType;
	
	private double amountPerKg;

	private String productImgLink;

	

	public ProductResponse(long productId, String productName, double amountPerKg, String productImgLink) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.amountPerKg = amountPerKg;
		this.productImgLink = productImgLink;
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
