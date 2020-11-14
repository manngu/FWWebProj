package com.fw.shopping.mypage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fw.shopping.order.model.OrderJoinVO;
import com.fw.shopping.qna.model.QnaVO;
import com.fw.shopping.review.model.ReviewVO;

@Service
public class MypageService implements IMypageService {

	@Inject
	private IMypageService mypageMapper;



	@Override
	public List<ReviewVO> getReviewList(ReviewVO review) {
		List<ReviewVO> reviewList = mypageMapper.getReviewList(review);
		return reviewList;
	}

	@Override
	public ReviewVO getReviewOne(int reviewNo) {
		return mypageMapper.getReviewOne(reviewNo);
	}

	@Override
	public List<QnaVO> getQnaList(QnaVO qna) {
		List<QnaVO> qnaList = mypageMapper.getQnaList(qna);
		return qnaList;
	}

	@Override
	public QnaVO getQnaOne(int qnaNo) {
		return mypageMapper.getQnaOne(qnaNo);
	}

	@Override
	public List<OrderJoinVO> getOrderDetailList(OrderJoinVO order) {
		List<OrderJoinVO> orderDetailList = mypageMapper.getOrderDetailList(order);
		return orderDetailList;
	}

	@Override
	public void orderStatus(OrderJoinVO orderDetailNo) {
		mypageMapper.orderStatus(orderDetailNo);
	}
	
}
