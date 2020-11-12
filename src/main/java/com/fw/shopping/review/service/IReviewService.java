package com.fw.shopping.review.service;

import java.util.List;

import com.fw.shopping.commons.SortVO;
import com.fw.shopping.review.model.ReviewVO;

public interface IReviewService {

	List<ReviewVO> getReviewList(int gdsNo, SortVO sort);
	
	ReviewVO getReviewInfo(int reviewNo);
	
	void addReply(int reviewRef, ReviewVO review); 
	
	void modifyReply(ReviewVO review);
	
	void deleteReview(int reviewNo); //회원 리뷰
	
	void deleteReply(int reviewNo);   //관리자 대댓
}
