package com.ibm.app.payload.request;

import java.util.Date;

public class DeleteStockRequest {
	
	String companyName;
	Date saveAt;
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getSaveAt() {
		return saveAt;
	}
	public void setSaveAt(Date saveAt) {
		this.saveAt = saveAt;
	}

	
	
	
}

