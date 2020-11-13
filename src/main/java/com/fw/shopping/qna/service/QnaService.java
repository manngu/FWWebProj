package com.fw.shopping.qna.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fw.shopping.qna.model.QnaVO;
import com.fw.shopping.qna.repository.IQnaMapper;

@Service
public class QnaService implements IQnaService {
	
	@Inject
	IQnaMapper mapper;
	
	@Override
	public List<QnaVO> getAdminQnaList() {
		return mapper.getAdminQnaList();
	}
	
	@Override
	public QnaVO getQnaInfo(int qnaNo) {
		return mapper.getQnaInfo(qnaNo);
	}
	
	
	
	

	@Override
	public List<QnaVO> getQnaList(int gdsNo) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void addQna(int qnaRef, QnaVO gna) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyQna(QnaVO qna) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteQna(int qnaNo) {
		// TODO Auto-generated method stub
		
	}

}
