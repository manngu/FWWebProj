package com.fw.shopping.review.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fw.shopping.commons.SortVO;
import com.fw.shopping.review.model.ReviewVO;
import com.fw.shopping.review.repository.IReviewMapper;

@Service
public class ReviewService implements IReviewService {
	
	@Inject
	IReviewMapper mapper;
	
	@Override
	public List<ReviewVO> getAdminReviewList() {
		return mapper.getAdminReviewList(); 
	}
	
	
	
	

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
