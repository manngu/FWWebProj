package com.fw.shopping.faq.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.faq.model.FaqVO;
import com.fw.shopping.faq.repository.IFaqMapper;

@Service
public class FaqService implements IFaqService {

	
	@Inject
	private IFaqMapper faqMapper;
	
	@Override
	public void addFaq(FaqVO faq) {
		faqMapper.addFaq(faq);
	}
	
	@Override
	public FaqVO getFaqInfo(int faqNo) {
		return faqMapper.getFaqInfo(faqNo);
	}

	@Override
	public void modifyFaq(FaqVO faq) {
		faqMapper.modifyFaq(faq);
	}
	
	@Override
	public void deleteFaq(int faqNo) {
		faqMapper.deleteFaq(faqNo);
	}
	
	@Override
	public List<FaqVO> getFaqList(SearchVO search) {
		List<FaqVO> faqList = faqMapper.getFaqList(search);
		
		return faqList;
	}

	@Override
	public Integer countFaqs(SearchVO search) {
		return faqMapper.countFaqs(search);

	}



}
