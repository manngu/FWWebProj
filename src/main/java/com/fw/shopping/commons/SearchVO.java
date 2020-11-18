package com.fw.shopping.commons;

public class SearchVO extends PageVO{//페이징(기본)+검색
	
	private String keyword;	//검색어
	private String condition;
	private String sort;	//분류/정렬
	//회원용 - 상품이름
	//관리자 - 거래일, 거래구분, 상품번호, 옵션번호, 주문번호, 매출액	
	
	public SearchVO() {
		this.keyword = "";
		this.condition = "";
		this.sort="";
	}
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}


	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}


	@Override
	public String toString() {
		return "SearchVO [keyword=" + keyword + ", condition=" + condition + ", sort=" + sort + "]";
	}
	
	
	
	
}
