package com.fw.shopping.category.model;

public class CateSelfJoinVO{

	private Integer cateNo; // pk
	private String refName;
	private String cateName;
	public Integer getCateNo() {
		return cateNo;
	}
	public void setCateNo(Integer cateNo) {
		this.cateNo = cateNo;
	}
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	@Override
	public String toString() {
		return "CateSelfJoinVO [cateNo=" + cateNo + ", refName=" + refName + ", cateName=" + cateName + "]";
	}
	
	


	
}