package com.fw.shopping.goods.model;

import java.util.Date;

public class GdsJoinVO {

	private Integer optionNo; // pk 
	private Integer gdsNo;
	private String optionName;
	private Integer optionCount;
	private Integer optionAddPrice;
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

	public Integer getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(Integer optionNo) {
		this.optionNo = optionNo;
	}
	public Integer getGdsNo() {
		return gdsNo;
	}
	public void setGdsNo(Integer gdsNo) {
		this.gdsNo = gdsNo;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public Integer getOptionCount() {
		return optionCount;
	}
	public void setOptionCount(Integer optionCount) {
		this.optionCount = optionCount;
	}
	public Integer getOptionAddPrice() {
		return optionAddPrice;
	}
	public void setOptionAddPrice(Integer optionAddPrice) {
		this.optionAddPrice = optionAddPrice;
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
		return "GdsJoinVO [optionNo=" + optionNo + ", gdsNo=" + gdsNo + ", optionName=" + optionName + ", optionCount="
				+ optionCount + ", optionAddPrice=" + optionAddPrice + ", cateCode=" + cateCode + ", gdsName=" + gdsName
				+ ", gdsDes=" + gdsDes + ", gdsThumbImg=" + gdsThumbImg + ", gdsRegDate=" + gdsRegDate + ", gdsDday="
				+ gdsDday + ", gdsType=" + gdsType + ", gdsSales=" + gdsSales + ", gdsStatus=" + gdsStatus
				+ ", gdsViewCnt=" + gdsViewCnt + ", gdsLimit=" + gdsLimit + ", gdsPrice=" + gdsPrice + ", gdsDiscount="
				+ gdsDiscount + "]";
	}
	
	


}
