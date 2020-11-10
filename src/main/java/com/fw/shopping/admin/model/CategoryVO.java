package com.fw.shopping.admin.model;

public class CategoryVO{

	private Integer cateCode; // pk
	private String cateName;
	private Integer cateRef;

	public Integer getCateCode() {
		return cateCode;
	}
	public void setCateCode(Integer cateCode) {
		this.cateCode = cateCode;
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
		return "CategoryVO [cateCode=" + cateCode + ", cateName=" + cateName + ", cateRef=" + cateRef + "]";
	}

	
}