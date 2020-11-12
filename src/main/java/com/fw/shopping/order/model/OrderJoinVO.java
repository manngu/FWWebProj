package com.fw.shopping.order.model;

import java.util.Date;

public class OrderJoinVO {

	private String orderId; // pk
	private Integer userNo;
	private String orderPerson;
	private String orderAddr1;
	private String orderAddr2;
	private String orderPhone;
	private Integer orderPrice;
	private Date orderRegDate;
	private Integer orderDetailsNo; // pk
	private Integer gdsNo;
	private Integer optionNo;
	private Integer orderStock;
	private Integer deliveryStatus;
	private Long invoiceNo;
	private Integer orderStatus;
	
	
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
	public Integer getOrderDetailsNo() {
		return orderDetailsNo;
	}
	public void setOrderDetailsNo(Integer orderDetailsNo) {
		this.orderDetailsNo = orderDetailsNo;
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
	public Integer getOrderStock() {
		return orderStock;
	}
	public void setOrderStock(Integer orderStock) {
		this.orderStock = orderStock;
	}
	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public Long getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(Long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderJoin [orderId=" + orderId + ", userNo=" + userNo + ", orderPerson=" + orderPerson + ", orderAddr1="
				+ orderAddr1 + ", orderAddr2=" + orderAddr2 + ", orderPhone=" + orderPhone + ", orderPrice="
				+ orderPrice + ", orderRegDate=" + orderRegDate + ", orderDetailsNo=" + orderDetailsNo + ", gdsNo="
				+ gdsNo + ", optionNo=" + optionNo + ", orderStock=" + orderStock + ", deliveryStatus=" + deliveryStatus
				+ ", invoiceNo=" + invoiceNo + ", orderStatus=" + orderStatus + "]";
	}
	
	
}
