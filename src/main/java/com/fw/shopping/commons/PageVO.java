package com.fw.shopping.commons;

public class PageVO {

	private int page;	//사용자가 요청한 페이지 번호
	private int countPerPage;	//한페이지당 들어갈 게시물의 수.
	
	public PageVO() {
		this.page=1;
		this.countPerPage=20;
	}
	

	public int getPageStart() {
		//[1]0-19, [2]20-39 [3]40-59 ... [n](n-1)*20
		return(this.page-1)*this.countPerPage;
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
		if(countPerPage<=0 || countPerPage > 50) {	//50은 자기 취향. 몇개 이상 보여주기 싫은지
			this.countPerPage=20;
			return;
		}
		this.countPerPage = countPerPage;
	}
	
	
}
