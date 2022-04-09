package com.ibm.app.payload.request;

public class ProductRequest {
	
	private String productName;
	
//	private String productType;
	
	private double amountPerKg;

	private String productImgLink;

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
