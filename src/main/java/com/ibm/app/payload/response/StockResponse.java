package com.ibm.app.payload.response;

import java.sql.Timestamp;
import java.util.Date;

import com.ibm.app.models.Stock;

public class StockResponse {
	long userId;
	int rank;
	String companyname;
	double bse;
	double nse;
	double percentDiff;
	String buy;
	Date saveAt;
	
	
	public StockResponse(long userId, int rank, String company, double bse, double nse, double profit, String buy, Date savedAt) {
		super();
		this.userId = userId;
		this.rank = rank;
		this.companyname = company;
		this.bse = bse;
		this.nse = nse;
		this.percentDiff = profit;
		this.buy = buy;
		this.saveAt = savedAt;
	}
	
	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public double getPercentProfit() {
		return percentDiff;
	}

	public void setPercentProfit(double percentProfit) {
		this.percentDiff = percentProfit;
	}

	public Date getSavedAt() {
		return saveAt;
	}

	public void setSavedAt(Timestamp savedAt) {
		this.saveAt = savedAt;
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
		return companyname;
	}
	public void setCompanyName(String companyName) {
		this.companyname = companyName;
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
	public void setBse(double bse) {
		this.bse = bse;
	}
	public double getNse() {
		return nse;
	}
	public void setNse(double nse) {
		this.nse = nse;
	}
//	public double getProfit() {
//		return percentProfit;
//	}
//	public void setProfit(double profit) {
//		this.percentProfit = profit;
//	}

	
	
}
