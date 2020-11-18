package com.fw.shopping.qna.service;

import java.util.List;

import com.fw.shopping.qna.model.QnaVO;

public interface IQnaService {

	List<QnaVO> getQnaList(int gdsNo);
	
	List<QnaVO> getReQnaList(int gdsNo);
	
	List<QnaVO> getMyQnaList(int userNo);
	
	List<QnaVO> getMyReQnaList(int qnaNo);
	
	QnaVO getQnaInfo(int qnaNo);
	
	void addQna(QnaVO qna);
	
	void modifyQna(QnaVO qna);
	
	void deleteQna(int qnaNo);

	String getMemberName(int reviewNo);
	
	List<QnaVO> getAdminQnaList(); //관리자가 확인해야할 qna리스트
}
