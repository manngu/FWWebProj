package com.fw.shopping.admin.model;

public class CategoryVO{

	private Integer cateCode; // pk
	private String cateName;
	private String cateRef;

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
	public String getCateRef() {
		return cateRef;
	}
	public void setCateRef(String cateRef) {
		this.cateRef = cateRef;
	}

	@Override
	public String toString() {
		return "CategoryVO [cateCode=" + cateCode + ", cateName=" + cateName + ", cateRef=" + cateRef + "]";
	}

	
}