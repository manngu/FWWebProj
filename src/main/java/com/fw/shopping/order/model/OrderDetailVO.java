package com.fw.shopping.order.model;

public class OrderDetailVO {
	
	private Integer orderDetailNo; // pk
	private Integer gdsNo;
	private String orderId;
	private Integer optionNo;
	private Integer orderStock;
	private Integer deliveryStatus;
	private Long invoiceNo;
	private Integer orderStatus;
	
	public Integer getOrderDetailNo() {
		return orderDetailNo;
	}
	public void setOrderDetailNo(Integer orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
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
		return "OrderDetailVO [orderDetailNo=" + orderDetailNo + ", gdsNo=" + gdsNo + ", orderId=" + orderId
				+ ", optionNo=" + optionNo + ", orderStock=" + orderStock + ", deliveryStatus=" + deliveryStatus
				+ ", invoiceNo=" + invoiceNo + ", orderStatus=" + orderStatus + "]";
	}

	

	
}