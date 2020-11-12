package com.fw.shopping.cart.model;

import java.util.Date;

public class CartVO{

	private Integer cartNo; // pk
	private Integer cartStock;	
	private Date cartRegDate;
	private Integer userNo;
	private Integer gdsNo;
	private Integer optionNo;

	
	public Integer getCartNo() {
		return cartNo;
	}
	public void setCartNo(Integer cartNo) {
		this.cartNo = cartNo;
	}
	public Integer getCartStock() {
		return cartStock;
	}
	public void setCartStock(Integer cartStock) {
		this.cartStock = cartStock;
	}
	public Date getCartRegDate() {
		return cartRegDate;
	}
	public void setCartRegDate(Date cartRegDate) {
		this.cartRegDate = cartRegDate;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public Integer getGdsNo() {
		return gdsNo;
	}
	public void setGdsNo(Integer gdsNo) {
		this.gdsNo = gdsNo;
	}
	public Integer getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(Integer optionNo) {
		this.optionNo = optionNo;
	}
	@Override
	public String toString() {
		return "CartVO [cartNo=" + cartNo + ", cartStock=" + cartStock + ", cartRegDate=" + cartRegDate + ", userNo="
				+ userNo + ", gdsNo=" + gdsNo + ", optionNo=" + optionNo + "]";
	}

	
	
}
