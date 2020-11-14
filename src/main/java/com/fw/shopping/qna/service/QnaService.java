package com.fw.shopping.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fw.shopping.qna.model.QnaVO;
import com.fw.shopping.qna.repository.IQnaMapper;

@Service
public class QnaService implements IQnaService {
	
	@Autowired
	private IQnaMapper mapper;
	
	@Override
	public List<QnaVO> getQnaList(int gdsNo) {
		List<QnaVO> list = mapper.getQnaList(gdsNo);
		return list;
	}
	
	@Override
	public List<QnaVO> getReQnaList(int gdsNo) {
		List<QnaVO> list = mapper.getReQnaList(gdsNo);
		return list;
	}

	@Override
	public QnaVO getQnaInfo(int qnaNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addQna(QnaVO qna) {
		if(qna.getQnaRef() == null) {
			mapper.addQna(qna);
		}else {
			mapper.addReQna(qna);
		}
	}

	@Override
	public void modifyQna(QnaVO qna) {
		mapper.modifyQna(qna);
	}

	@Override
	public void deleteQna(int qnaNo) {
		mapper.deleteQna(qnaNo);
	}

	@Override
	public List<QnaVO> getMyQnaList(int userNo) {
		List<QnaVO> list = mapper.getMyQnaList(userNo);
		return list;
	}

}
