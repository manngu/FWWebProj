package com.fw.shopping.faq.service;

import java.util.List;

import com.fw.shopping.admin.model.SearchVO;
import com.fw.shopping.faq.model.FaqVO;

public interface IFaqService {

	//FAQ 등록 기능
	void addFaq(FaqVO faq);
	
	//FAQ 게시글 상세 조회
	FaqVO getFaqInfo(int faqNo);
	
	//FAQ 수정 기능
	void modifyFaq(FaqVO faq);
	
	//FAQ 삭제 기능
	void deleteFaq(int faqNo);

	//검색, 페이징 기능이 포함된 FAQ 목록 조회
	List<FaqVO> getFaqList(SearchVO search);	//정렬은 최신순. 검색기능
	Integer countFaqs(SearchVO search);
	
}
