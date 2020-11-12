package com.fw.shopping.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fw.shopping.commons.SortVO;
import com.fw.shopping.review.model.ReviewVO;

@Service
public class ReviewService implements IReviewService {

	@Override
	public List<ReviewVO> getReviewList(int gdsNo, SortVO sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReviewVO getReviewInfo(int reviewNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addReply(int reviewRef, ReviewVO review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyReply(ReviewVO review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReview(int reviewNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReply(int reviewNo) {
		// TODO Auto-generated method stub
		
	}

}
