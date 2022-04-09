package com.ibm.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.repository.Temporal;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;

@Entity
@Table(name = "saved_stocks")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stock_id")
	long id;
	@Column(name="stock_rank")
	int rank;
	@Column(name="company_name")
	String companyName;
	@Column(name="nse")
	double nsePrice;
	@Column(name="bse")
	double bsePrice;
	@Column(name="percent_profit")
	double percentDiff;
	@Column(name="buy_from")
	String buyFrom;
//	@Column(name="stock_count")
//	String totalStocks;

	@javax.persistence.Temporal(TemporalType.TIMESTAMP)
	@Column(name="saved_at", nullable = false)
	Date saved_at;

	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

	@PrePersist
	private void onCreate() {
		saved_at=new Date();
	}
	
	public Stock() {
		this.rank = 0;
		this.companyName = "";
		this.nsePrice = 0.0f;
		this.bsePrice = 0.0f;
		this.percentDiff = 0.0f;
		this.buyFrom = "";
	}
	public Stock(int rank, String companyName, double nsePrice, double bsePrice, double percentProfit,
			 String buyFrom) {
	
		this.rank = rank;
		this.companyName = companyName;
		this.nsePrice = nsePrice;
		this.bsePrice = bsePrice;
		this.percentDiff = percentProfit;
		this.buyFrom = buyFrom;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getNsePrice() {
		return nsePrice;
	}
	public void setNsePrice(double nsePrice) {
		this.nsePrice = nsePrice;
	}
	public double getBsePrice() {
		return bsePrice;
	}
	public void setBsePrice(double bsePrice) {
		this.bsePrice = bsePrice;
	}
	
	public Date getSaved_at() {
		return saved_at;
	}

	public void setSaved_at(Date saved_at) {
		this.saved_at = saved_at;
	}

	public double getPercentDiff() {
		return percentDiff;
	}

	public void setPercentDiff(double percentDiff) {
		this.percentDiff = percentDiff;
	}

	public String getBuyFrom() {
		return buyFrom;
	}
	public void setBuyFrom(String buyFrom) {
		this.buyFrom = buyFrom;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getCurrentTimestamp() {
		return saved_at;
	}
	public void setCurrentTimestamp(Timestamp currentTimestamp) {
		this.saved_at = currentTimestamp;
	}
	
}
