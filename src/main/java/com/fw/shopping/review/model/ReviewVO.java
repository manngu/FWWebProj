package com.fw.shopping.review.model;

import java.util.Date;

public class ReviewVO {
	
	private Integer reviewNo; // pk
	private Integer gdsNo;
	private String orderId;
	private Integer userNo;
	private Integer reviewRef;
	private String reviewImg;
	private String reviewContent;
	private Integer reviewStars;
	private Date reviewRegDate;
	
	public Integer getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(Integer reviewNo) {
		this.reviewNo = reviewNo;
	}
	public Integer getGdsNo() {
		return gdsNo;
	}
	public void setGdsNo(Integer gdsNo) {
		this.gdsNo = gdsNo;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public Integer getReviewRef() {
		return reviewRef;
	}
	public void setReviewRef(Integer reviewRef) {
		this.reviewRef = reviewRef;
	}
	public String getReviewImg() {
		return reviewImg;
	}
	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Integer getReviewStars() {
		return reviewStars;
	}
	public void setReviewStars(Integer reviewStars) {
		this.reviewStars = reviewStars;
	}
	
	public Date getReviewRegDate() {
		return reviewRegDate;
	}
	public void setReviewRegDate(Date reviewRegDate) {
		this.reviewRegDate = reviewRegDate;
	}
	
	@Override
	public String toString() {
		return "ReviewVO [reviewNo=" + reviewNo + ", gdsNo=" + gdsNo + ", orderId=" + orderId + ", userNo=" + userNo
				+ ", reviewRef=" + reviewRef + ", reviewImg=" + reviewImg + ", reviewContent=" + reviewContent
				+ ", reviewStars=" + reviewStars + ", reviewRegDate=" + reviewRegDate
				+ "]";
	}


	
	

}
