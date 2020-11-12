package com.fw.shopping.faq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.faq.model.FaqVO;

@Service
public class FaqService implements IFaqService {

	@Override
	public List<FaqVO> getFaqList(SearchVO search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FaqVO getFaqInfo(int faqNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFaq(FaqVO faq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyFaq(FaqVO faq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFaq(int faqNo) {
		// TODO Auto-generated method stub
		
	}

}
