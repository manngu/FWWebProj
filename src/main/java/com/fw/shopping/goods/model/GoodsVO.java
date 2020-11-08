package com.fw.shopping.goods.model;

import java.util.Date;

public class GoodsVO{

	private Integer gdsNo; // pk
	private Integer cateCode;
	private String gdsName;
	private String gdsDes;
	private String gdsThumbImg;
	private Date gdsRegDate;
	private Date gdsDday;
	private Integer gdsType;
	private Integer gdsSales;
	private Integer gdsStatus;
	private Integer gdsViewCnt;
	private Integer gdsLimit;
	private Integer gdsPrice;
	private double gdsDiscount;

	public Integer getGdsNo() {
		return gdsNo;
	}
	public void setGdsNo(Integer gdsNo) {
		this.gdsNo = gdsNo;
	}
	public Integer getCateCode() {
		return cateCode;
	}
	public void setCateCode(Integer cateCode) {
		this.cateCode = cateCode;
	}
	public String getGdsName() {
		return gdsName;
	}
	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}
	public String getGdsDes() {
		return gdsDes;
	}
	public void setGdsDes(String gdsDes) {
		this.gdsDes = gdsDes;
	}
	public String getGdsThumbImg() {
		return gdsThumbImg;
	}
	public void setGdsThumbImg(String gdsThumbImg) {
		this.gdsThumbImg = gdsThumbImg;
	}
	public Date getGdsRegDate() {
		return gdsRegDate;
	}
	public void setGdsRegDate(Date gdsRegDate) {
		this.gdsRegDate = gdsRegDate;
	}
	public Date getGdsDday() {
		return gdsDday;
	}
	public void setGdsDday(Date gdsDday) {
		this.gdsDday = gdsDday;
	}
	public Integer getGdsType() {
		return gdsType;
	}
	public void setGdsType(Integer gdsType) {
		this.gdsType = gdsType;
	}
	public Integer getGdsSales() {
		return gdsSales;
	}
	public void setGdsSales(Integer gdsSales) {
		this.gdsSales = gdsSales;
	}
	public Integer getGdsStatus() {
		return gdsStatus;
	}
	public void setGdsStatus(Integer gdsStatus) {
		this.gdsStatus = gdsStatus;
	}
	public Integer getGdsViewCnt() {
		return gdsViewCnt;
	}
	public void setGdsViewCnt(Integer gdsViewCnt) {
		this.gdsViewCnt = gdsViewCnt;
	}
	public Integer getGdsLimit() {
		return gdsLimit;
	}
	public void setGdsLimit(Integer gdsLimit) {
		this.gdsLimit = gdsLimit;
	}
	public Integer getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(Integer gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	public double getGdsDiscount() {
		return gdsDiscount;
	}
	public void setGdsDiscount(double gdsDiscount) {
		this.gdsDiscount = gdsDiscount;
	}

	@Override
	public String toString() {
		return "GoodsVO [gdsNo=" + gdsNo + ", cateCode=" + cateCode + ", gdsName=" + gdsName + ", gdsDes=" + gdsDes
				+ ", gdsThumbImg=" + gdsThumbImg + ", gdsRegDate=" + gdsRegDate + ", gdsDday=" + gdsDday + ", gdsType="
				+ gdsType + ", gdsSales=" + gdsSales + ", gdsStatus=" + gdsStatus + ", gdsViewCnt=" + gdsViewCnt
				+ ", gdsLimit=" + gdsLimit + ", gdsPrice=" + gdsPrice + ", gdsDiscount=" + gdsDiscount + "]";
	}

	
	
}