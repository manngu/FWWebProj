package com.fw.shopping.review.service;

import java.util.List;

import com.fw.shopping.admin.model.SortingVO;
import com.fw.shopping.review.model.ReviewVO;

public interface IReviewService {

	List<ReviewVO> getReviewList(int gdsNo);
	
	List<ReviewVO> getReReviewList(int gdsNo); // 리뷰 댓글 리스트 가져오기
	
	List<ReviewVO> getMyReviewList(int userNo); // 본인 리뷰 리스트 가져오기
	
	ReviewVO getReviewInfo(int reviewNo);
	
	void addReview(ReviewVO review); 
	
	void modifyReview(ReviewVO review);
	
	void deleteReview(int reviewNo); //회원 리뷰
	
	void deleteReply(int reviewNo);   //관리자 대댓

}
