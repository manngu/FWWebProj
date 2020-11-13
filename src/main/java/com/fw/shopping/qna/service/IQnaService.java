package com.fw.shopping.qna.service;

import java.util.List;

import com.fw.shopping.qna.model.QnaVO;

public interface IQnaService {
	
	List<QnaVO> getAdminQnaList();
	
	QnaVO getQnaInfo(int qnaNo);
	
	
	
	

	List<QnaVO> getQnaList(int gdsNo);
	
	
	

	
	void addQna(int qnaRef, QnaVO gna);
	
	void modifyQna(QnaVO qna);
	
	void deleteQna(int qnaNo);
}
