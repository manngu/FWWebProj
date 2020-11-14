package com.fw.shopping.qna.repository;

import java.util.List;

import com.fw.shopping.qna.model.QnaVO;

public interface IQnaMapper {

	List<QnaVO> getQnaList(int gdsNo);
	
	List<QnaVO> getReQnaList(int gdsNo);
	
	List<QnaVO> getMyQnaList(int userNo);
		
	QnaVO getQnaInfo(int qnaNo);
	
	void addQna(QnaVO qna);
	
	void addReQna(QnaVO qna);
	
	void modifyQna(QnaVO qna);
	
	void deleteQna(int qnaNo);

}
