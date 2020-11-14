package com.fw.shopping.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fw.shopping.review.model.ReviewVO;
import com.fw.shopping.review.repository.IReviewMapper;

@Service
public class ReviewService implements IReviewService {

	@Autowired
	private IReviewMapper mapper;
	
	@Override
	public List<ReviewVO> getReviewList(int gdsNo) {
		List<ReviewVO> List = mapper.getReviewList(gdsNo);
		return List;
	}
	
	@Override
	public List<ReviewVO> getReReviewList(int gdsNo) {
		List<ReviewVO> List = mapper.getReReviewList(gdsNo);
		return List;
	}

	@Override
	public ReviewVO getReviewInfo(int reviewNo) {
		ReviewVO vo = mapper.getReviewInfo(reviewNo);
		return vo;
	}

	@Override
	public void addReview(ReviewVO review) {
		if(review.getReviewRef() == null) {
			mapper.addReview(review);
		}else {
			mapper.addReReview(review);
		}
	}

	@Override
	public void modifyReview(ReviewVO review) {
		if(review.getReviewRef() != null) {
			mapper.modifyReview(review);
		}else {
			mapper.modifyReReview(review);
		}
	}

	@Override
	public void deleteReview(int reviewNo) {
		mapper.deleteReview(reviewNo);
	}

	@Override
	public void deleteReply(int reviewNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReviewVO> getMyReviewList(int userNo) {
		List<ReviewVO> List = mapper.getMyReviewList(userNo);
		return List;
	}

}
