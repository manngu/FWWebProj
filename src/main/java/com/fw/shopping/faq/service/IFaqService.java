package com.fw.shopping.faq.service;

import java.util.List;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.faq.model.FaqVO;

public interface IFaqService {

	List<FaqVO> getFaqList(SearchVO search);	//정렬은 최신순. 검색기능
	
	FaqVO getFaqInfo(int faqNo);
	
	void addFaq(FaqVO faq);
	
	void modifyFaq(FaqVO faq);
	
	void deleteFaq(int faqNo);
}
