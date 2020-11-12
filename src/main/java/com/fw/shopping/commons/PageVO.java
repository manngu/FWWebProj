package com.fw.shopping.commons;

public class PageVO {
	private int page;	//사용자가 요청한 페이지 번호
	private int countPerPage;	//한페이지당 들어갈 게시물의 수.
	
	
	public PageVO() {
		this.page = 1;
		this.countPerPage = 20;
	}
	
	//요청 페이지의 시작 인덱스
	public int getPageStart() { 
		return(this.page-1)*this.countPerPage+1;
	}
	
	//요청 페이지의 끝 인덱스
	public int getPageEnd() {
		return this.page*this.countPerPage;
	}
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page<=0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	public int getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(int countPerPage) {
		if(countPerPage<=0 || countPerPage > 30) {	
			this.countPerPage=10;
			return;
		}
		this.countPerPage = countPerPage;
	}
}
