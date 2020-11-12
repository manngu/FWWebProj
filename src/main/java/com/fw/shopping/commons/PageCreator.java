package com.fw.shopping.commons;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

//페이지 알고리즘에 의해 이전, 다음 버튼, 페이지 버튼 갯수 및 번호를 관장할 객체. 
public class PageCreator {

	//page: 사용자가 요청항 페이지번호, countPerPage: 한 페이지당 들어갈 게시물 수
	private PageVO paging;

	private int articleTotalCount;	//게시판의 총 게시물 수
	private int beginPage; 	//시작 페이지 번호
	private int endPage;	//끝 페이지 번호
	private boolean prev;	//이전 버튼 활성화 여부
	private boolean next;	//다음 버튼 활성화 여부

	//한 화면에 보여질 페이지 버튼 수
	private final int displayPageNum = 10; //외부에서 이 값을 변경하지 못하도록 final선언.

	//페이징 알고리즘을 수행할 메서드 선언.
	private void calcDataOfPage() {

		//보정 전 끝 페이지 구하기
		endPage = (int)Math.ceil((double)paging.getPage()/displayPageNum)*displayPageNum;

		//시작 페이지 번호 구하기
		beginPage = endPage - 10 + 1;

		//현재 시작 페이지가 1이라면 이전 버튼 활성화 여부를 false로 지정
		prev = (beginPage == 1 ? false : true);

		//마지막 페이지인지 여부 확인 후 다음 버튼 비활성화 판단
		next = articleTotalCount<=endPage*paging.getCountPerPage() ? false: true;

		//다음 버튼 비활성화라면 끝페이지 재보정 하기
		if(!next) {
			endPage = (int)Math.ceil((double)articleTotalCount/paging.getCountPerPage());
		}


	}

	//URI 파라미터를 쉽게 만들어주는 유틸 메서드 선언
	public String makeURI(int page) {
		UriComponents ucp = UriComponentsBuilder.newInstance()	//path는 다른곳에서 쓸 수 도 있으니까 여기서 고정시키지 않겠다.
				.queryParam("page", page)	//현재 페이지만 걍 매개변수로 받아서 처리해주자
				.queryParam("countPerPage", paging.getCountPerPage())
				.queryParam("keyword", ((SearchVO)paging).getKeyword()) //pageCreator에 search가 들어오는데..부모타입에 자식타입이 들어올 수있다. 그런데 자식메서드는 사용불가->강제형변환
				.queryParam("condition", ((SearchVO)paging).getCondition())
				.build();
		return ucp.toUriString();											
	}

	public PageVO getPaging() {
		return paging;
	}

	public void setPaging(PageVO paging) {
		this.paging = paging;
	}

	public int getArticleTotalCount() {
		return articleTotalCount;
	}

	public void setArticleTotalCount(int articleTotalCount) {
		this.articleTotalCount = articleTotalCount;
		calcDataOfPage();
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {	//boolean타입은 getter에 대해 is가 관례로 붙는다. 
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {	//final로 지정해서 setter없이 생성됐다. 
		return displayPageNum;
	}

	@Override
	public String toString() {
		return "PageCreator [paging=" + paging + ", articleTotalCount=" + articleTotalCount + ", beginPage=" + beginPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum
				+ "]";
	}
}
