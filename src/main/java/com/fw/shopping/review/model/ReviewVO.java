package com.fw.shopping.review.model;

import java.util.Date;

public class ReviewVO {
	
	private Integer ReviewNo; // pk
	private Integer gdsNo;
	private String orderId;
	private Integer userNo;
	private Integer ReviewRef;
	private String ReviewImg;
	private String ReviewContent;
	private Integer ReviewStars;
	private Integer ReviewLike;
	private Date ReviewRegDate;

	public Integer getReviewNo() {
		return ReviewNo;
	}
	public void setReviewNo(Integer reviewNo) {
		ReviewNo = reviewNo;
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
		return ReviewRef;
	}
	public void setReviewRef(Integer reviewRef) {
		ReviewRef = reviewRef;
	}
	public String getReviewImg() {
		return ReviewImg;
	}
	public void setReviewImg(String reviewImg) {
		ReviewImg = reviewImg;
	}
	public String getReviewContent() {
		return ReviewContent;
	}
	public void setReviewContent(String reviewContent) {
		ReviewContent = reviewContent;
	}
	public Integer getReviewStars() {
		return ReviewStars;
	}
	public void setReviewStars(Integer reviewStars) {
		ReviewStars = reviewStars;
	}
	public Integer getReviewLike() {
		return ReviewLike;
	}
	public void setReviewLike(Integer reviewLike) {
		ReviewLike = reviewLike;
	}
	public Date getReviewRegDate() {
		return ReviewRegDate;
	}
	public void setReviewRegDate(Date reviewRegDate) {
		ReviewRegDate = reviewRegDate;
	}

	@Override
	public String toString() {
		return "ReviewVO [ReviewNo=" + ReviewNo + ", gdsNo=" + gdsNo + ", orderId=" + orderId + ", userNo=" + userNo
				+ ", ReviewRef=" + ReviewRef + ", ReviewImg=" + ReviewImg + ", ReviewContent=" + ReviewContent
				+ ", ReviewStars=" + ReviewStars + ", ReviewLike=" + ReviewLike + ", ReviewRegDate=" + ReviewRegDate
				+ "]";
	}
	
	

}
