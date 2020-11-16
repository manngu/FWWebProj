package com.fw.shopping.category.model;

public class CategoryVO{

	private Integer cateNo; // pk
	private String cateName;
	private Integer cateRef;

	public Integer getCateNo() {
		return cateNo;
	}
	public void setCateNo(Integer cateNo) {
		this.cateNo = cateNo;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public Integer getCateRef() {
		return cateRef;
	}
	public void setCateRef(Integer cateRef) {
		this.cateRef = cateRef;
	}

	@Override
	public String toString() {
		return "CategoryVO [cateNo=" + cateNo + ", cateName=" + cateName + ", cateRef=" + cateRef + "]";
	}

	
}