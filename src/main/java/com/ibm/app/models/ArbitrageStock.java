package com.ibm.app.models;

public class ArbitrageStock {
	
	int rank;
	String companyname;
	Float nse;
	Float bse;
	Float priceDiff;
	Float percentDiff;
	
	String buy;
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public Float getNse() {
		return nse;
	}
	public void setNse(Float nse) {
		this.nse = nse;
	}
	public Float getBse() {
		return bse;
	}
	public void setBse(Float bse) {
		this.bse = bse;
	}
	public Float getPriceDiff() {
		return priceDiff;
	}
	public void setPriceDiff(Float priceDiff) {
		this.priceDiff = priceDiff;
	}
	public String getBuy() {
		return buy;
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
		
	public Float getPercentDiff() {
		return percentDiff;
	}
	
	public void setPercentDiff(Float percentDiff) {
		this.percentDiff = percentDiff;
	}
}

