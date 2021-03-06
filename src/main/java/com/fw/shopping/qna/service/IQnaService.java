package com.fw.shopping.qna.service;

import java.util.List;

import com.fw.shopping.qna.model.QnaVO;

public interface IQnaService {

	List<QnaVO> getQnaList(int gdsNo);
	
	QnaVO getQnaInfo(int qnaNo);
	
	void addQna(int qnaRef, QnaVO gna);
	
	void modifyQna(QnaVO qna);
	
	void deleteQna(int qnaNo);
}
