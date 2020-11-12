package com.fw.shopping.order.model;

import java.util.Date;

public class OrderVO{
	private String orderId; // pk
	private Integer userNo;
	private String orderPerson;
	private String orderAddr1;
	private String orderAddr2;
	private String orderPhone;
	private Integer orderPrice;
	private Date orderRegDate;

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
	public String getOrderPerson() {
		return orderPerson;
	}
	public void setOrderPerson(String orderPerson) {
		this.orderPerson = orderPerson;
	}
	public String getOrderAddr1() {
		return orderAddr1;
	}
	public void setOrderAddr1(String orderAddr1) {
		this.orderAddr1 = orderAddr1;
	}
	public String getOrderAddr2() {
		return orderAddr2;
	}
	public void setOrderAddr2(String orderAddr2) {
		this.orderAddr2 = orderAddr2;
	}
	public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public Integer getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Date getOrderRegDate() {
		return orderRegDate;
	}
	public void setOrderRegDate(Date orderRegDate) {
		this.orderRegDate = orderRegDate;
	}

	@Override
	public String toString() {
		return "OrderVO [orderId=" + orderId + ", userNo=" + userNo + ", orderPerson=" + orderPerson + ", orderAddr1="
				+ orderAddr1 + ", orderAddr2=" + orderAddr2 + ", orderPhone=" + orderPhone + ", orderPrice="
				+ orderPrice + ", orderRegDate=" + orderRegDate + "]";
	}
	
	
	
}