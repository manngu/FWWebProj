package com.fw.shopping.goods.model;

import java.sql.Timestamp;


public class GdsJoinCateVO {
	
	private int gdsNo;
	private String cateName;
	private String gdsName;
	private int gdsSales;
	private Timestamp gdsRegDate;
	private Timestamp gdsDday;
	private int gdsStatus;
	
	public int getGdsNo() {
		return gdsNo;
	}
	public void setGdsNo(int gdsNo) {
		this.gdsNo = gdsNo;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getGdsName() {
		return gdsName;
	}
	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}
	public int getGdsSales() {
		return gdsSales;
	}
	public void setGdsSales(int gdsSales) {
		this.gdsSales = gdsSales;
	}
	public Timestamp getGdsRegDate() {
		return gdsRegDate;
	}
	public void setGdsRegDate(Timestamp gdsRegDate) {
		this.gdsRegDate = gdsRegDate;
	}
	public Timestamp getGdsDday() {
		return gdsDday;
	}
	public void setGdsDday(Timestamp gdsDday) {
		this.gdsDday = gdsDday;
	}
	public int getGdsStatus() {
		return gdsStatus;
	}
	public void setGdsStatus(int gdsStatus) {
		this.gdsStatus = gdsStatus;
	}
	@Override
	public String toString() {
		return "GdsJoinCateVO [gdsNo=" + gdsNo + ", cateName=" + cateName + ", gdsName=" + gdsName + ", gdsSales="
				+ gdsSales + ", gdsRegDate=" + gdsRegDate + ", gdsDday=" + gdsDday + ", gdsStatus=" + gdsStatus + "]";
	}
	
	


	
	

}
