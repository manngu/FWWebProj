package com.fw.shopping.admin.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fw.shopping.qna.model.QnaVO;
import com.fw.shopping.review.model.ReviewVO;
import com.fw.shopping.review.service.IReviewService;

@Controller
@RequestMapping("/admin/reviews")
public class AdminReviewController {
	
	@Inject
	IReviewService revService;
	
	//리뷰관리 페이지 연결
	@GetMapping
	public String reviewList(Model model) {
		List<ReviewVO> list = revService.getAdminReviewList();
		model.addAttribute("list", list);
		return "admin/review/list";
	}
	
	//review 답변 페이지 호출
	@GetMapping("/{reviewNo}")
	public String replyPage(@PathVariable("reviewNo") int reviewNo, Model model) {
		model.addAttribute("rev", revService.getReviewInfo(reviewNo));
		return "admin/review/replyPost";
	}
	
	//review 답변
	@PostMapping("/reply")
	public String replyReview(ReviewVO review) {
		
		System.out.println(review);
		revService.addReview(review);
		return "redirect:/admin/reviews";
	}

}
