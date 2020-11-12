package com.fw.shopping.faq.repository;

import java.util.List;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.faq.model.FaqVO;

public interface IFaqMapper {

	List<FaqVO> getFaqList(SearchVO search);	//정렬은 최신순. 검색기능
	
	FaqVO getFaqInfo(int faqNo);
	
	void addFaq(FaqVO faq);
	
	void modifyFaq(FaqVO faq);
	
	void deleteFaq(int faqNo);

}
