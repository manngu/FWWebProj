package com.fw.shopping.mypage.repository;

import java.util.List;

import com.fw.shopping.order.model.OrderJoinVO;
import com.fw.shopping.qna.model.QnaVO;
import com.fw.shopping.review.model.ReviewVO;

public interface IMypageMapper {

	//리뷰 목록 보기
	List<ReviewVO> getReviewList(ReviewVO review);
	
	//리뷰 상세 보기
	ReviewVO getReviewOne(int reviewNo);
	
	//QNA 목록 보기
	List<QnaVO> getQnaList(QnaVO qna);
	
	//QNA 상세 보기
	QnaVO getQnaOne(int qnaNo);
	
	//주문리스트 확인
	List<OrderJoinVO> getOrderDetailList(OrderJoinVO order);
	
	//취소, 교환, 환불 요청
	void orderStatus(OrderJoinVO orderDetailNo);
}
