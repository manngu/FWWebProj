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
	
//	//QNA 답변 페이지 호출
//	@GetMapping("/{qnaNo}")
//	public String answerPage(@PathVariable("qnaNo") int qnaNo, Model model) {
//		model.addAttribute("q", qnaService.getQnaInfo(qnaNo));
//		return "admin/answer";
//	}
//	
//	//QNA 답변
//	@PostMapping("/answer")
//	public String answer(QnaVO answer) {
//		//System.out.println(answer);
//		//이 부분은 홍무씨가 한 거 따오자~
//		return "redirect:/admin/qnas";
//		
//	}

}
