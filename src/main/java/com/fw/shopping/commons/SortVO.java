package com.fw.shopping.commons;


public class SortVO {

	private String sort; 
	//상품정렬 - 조회순, 판매량순, 낮은가격순, 신상순
	//리뷰정렬 - 평가순, 최신순
	
	
	public SortVO() {
		this.sort = "";
	}

	
	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}
	

	
}
