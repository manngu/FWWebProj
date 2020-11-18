package com.fw.shopping.cart.model;

import java.sql.Timestamp;

public class CartJoinVO {
	private int cartNo;
	private int userNo;
	private int gdsNo;
	private int optionNo;
	private int cartStock;
	private Timestamp cartRegDate;
	private String gdsName;
	private String optionName;
	
	private int gdsPrice;
	private int optionAddPrice;
	
	
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getGdsNo() {
		return gdsNo;
	}
	public void setGdsNo(int gdsNo) {
		this.gdsNo = gdsNo;
	}
	public int getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}
	public int getCartStock() {
		return cartStock;
	}
	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
	public Timestamp getCartRegDate() {
		return cartRegDate;
	}
	public void setCartRegDate(Timestamp cartRegDate) {
		this.cartRegDate = cartRegDate;
	}
	public String getGdsName() {
		return gdsName;
	}
	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	
	
	public int getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	public int getOptionAddPrice() {
		return optionAddPrice;
	}
	public void setOptionAddPrice(int optionAddPrice) {
		this.optionAddPrice = optionAddPrice;
	}
	@Override
	public String toString() {
		return "CartJoinVO [cartNo=" + cartNo + ", userNo=" + userNo + ", gdsNo=" + gdsNo + ", optionNo=" + optionNo
				+ ", cartStock=" + cartStock + ", cartRegDate=" + cartRegDate + ", gdsName=" + gdsName + ", optionName="
				+ optionName + ", gdsPrice=" + gdsPrice + ", optionAddPrice=" + optionAddPrice + "]";
	}

	
	
	

}
