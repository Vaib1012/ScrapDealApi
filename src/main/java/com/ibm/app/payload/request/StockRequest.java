package com.ibm.app.payload.request;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

public class StockRequest {
	
	long userId;
	int rank;
	String companyName;
	double bse;
	double nse;
	double percentDiff;
	String buy;
	
	
	public void setBse(double bse) {
		this.bse = bse;
	}
	public void setNse(double nse) {
		this.nse = nse;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getBuy() {
		return buy;
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
	
	public double getBse() {
		return bse;
	}
	public void setBse(float bse) {
		this.bse = bse;
	}
	public double getNse() {
		return nse;
	}
	public void setNse(float nse) {
		this.nse = nse;
	}
	public double getPercentDiff() {
		return percentDiff;
	}
	public void setPercentDiff(double percentDiff) {
		this.percentDiff = percentDiff;
	}
	
	

}
