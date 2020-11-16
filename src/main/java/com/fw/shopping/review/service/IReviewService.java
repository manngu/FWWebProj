package com.fw.shopping.review.service;

import java.util.List;

import com.fw.shopping.review.model.ReviewVO;

public interface IReviewService {

	List<ReviewVO> getReviewList(int gdsNo);
	
	List<ReviewVO> getReReviewList(int gdsNo); // 리뷰 댓글 리스트 가져오기
	
	List<ReviewVO> getMyReviewList(int userNo); // 본인 리뷰 리스트 가져오기
	
	List<ReviewVO> getMyReReviewList(int reviewNo);
	
	List<ReviewVO> getReviewInfo(int reviewNo); //내가 쓴 리뷰 보기
	
	//ReviewVO getReviewInfo(int reviewNo);
	
	void addReview(ReviewVO review); 
	
	void addReReview(ReviewVO review); //리뷰 댓글 추가
	
	void modifyReview(ReviewVO review);
	
	void modifyReReview(ReviewVO review); // 리뷰 댓글 수정하기
	
	void deleteReview(int reviewNo); //회원 리뷰
	
	void deleteReply(int reviewNo);   //관리자 대댓
	
	String getMemberName(int reviewNo);
	
	List<ReviewVO> getAdminReviewList(); //관리자가 확인해야할 리뷰 목록

}
