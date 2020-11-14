package com.fw.shopping.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fw.shopping.review.model.ReviewVO;
import com.fw.shopping.review.service.IReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private IReviewService service;
	
	@GetMapping("/{gdsNo}")
	public String list(@PathVariable int gdsNo, Model model) {		
		
		List<ReviewVO> List = service.getReviewList(gdsNo);
		List<ReviewVO> ReList = service.getReReviewList(gdsNo);
		
		System.out.println(List);
		System.out.println(ReList);
		model.addAttribute("List", List);		
		model.addAttribute("ReList", ReList);
		
		return "review/gdsList";
	}
	
	@GetMapping("/reviewWrite")
	public String reviewWrite(Model model) {
		
		return "review/reviewWrite";
	}
	
	@GetMapping("/replyWrite")
	public String replyWrite(ReviewVO vo, Model model) {
		
		//임의로 테이블에서 오더 아이디 디펄트 값  2001 로 잡아놓음
		System.out.println("reply : "+vo.getReviewRef());
		System.out.println("userNO : "+vo.getUserNo());
		System.out.println("orderId : "+vo.getOrderId());
		
		model.addAttribute("vo", vo);
		
		list(vo.getGdsNo(), model);
		
		return "review/gdsList";
	}
	
	@GetMapping("/insert")
	public String insert(ReviewVO vo) {
				
		System.out.println("리뷰 작성 : "+vo);
		service.addReview(vo);
		
		return "redirect:/review/"+vo.getGdsNo();
	}
	

	@GetMapping("/modify")
	public String modify(int reviewNo,int gdsNo, Model model) {
		
		int modifyNo = reviewNo;
		
		System.out.println("modifyNo : "+modifyNo);
		
		model.addAttribute("modifyNo", modifyNo);
		
		list(gdsNo, model);
		
		return "review/gdsList";
	}
	
	@PostMapping("/modify")
	public String modify(ReviewVO vo) {
		
		System.out.println("수정할 리뷰 정보 : "+vo);
		service.modifyReview(vo);
		
		return "redirect:/review/"+vo.getGdsNo();
	}
	
	@PostMapping("/delete")
	public String deleteReview(ReviewVO vo) {
		
		System.out.println("리뷰 삭제 요청");
		System.out.println("gdsNo : " +vo.getGdsNo());
		service.deleteReview(vo.getReviewNo());
		
		return "redirect:/review/"+vo.getGdsNo();
	}
	
	
	
	
}
