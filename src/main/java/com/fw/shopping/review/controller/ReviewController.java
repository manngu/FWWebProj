package com.fw.shopping.review.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fw.shopping.goods.controller.GoodsController;
import com.fw.shopping.review.model.ReviewVO;
import com.fw.shopping.review.service.IReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private IReviewService service;
	
	
	@GetMapping("/replyWrite")
	public String replyWrite(ReviewVO vo, Model model) {

		//임의로 테이블에서 오더 아이디 디펄트 값  2001 로 잡아놓음
		System.out.println("reply : "+vo.getReviewRef());
		System.out.println("userNO : "+vo.getUserNo());
		System.out.println("orderId : "+vo.getOrderId());
		System.out.println("gdsNo : "+vo.getGdsNo());
		
		model.addAttribute("vo", vo);
		
		return "forward:/goods/"+vo.getGdsNo()+"/replyWrite";
	}
	
	@GetMapping("/insert")
	public String insert(ReviewVO vo, Model model) {
				
		System.out.println("리뷰 작성 : "+vo);
		service.addReview(vo);
		
		return "redirect:/goods/"+vo.getGdsNo();
	}
	
	
	@GetMapping("/modify")
	public String modify(int reviewNo,int gdsNo, Model model) {
		
		int modifyNo = reviewNo;
		
		System.out.println("modifyNo : "+modifyNo);
		
		model.addAttribute("modifyNo", modifyNo);
		
		return "redirect:/goods/"+gdsNo+"/reviewModify";
	}
	
	@PostMapping("/modify")
	public String modify(ReviewVO vo) {
		
		System.out.println("수정할 리뷰 정보 : "+vo);
		service.modifyReview(vo);
		
		return "redirect:/goods/"+vo.getGdsNo();
	}
	
	@PostMapping("/delete")
	public String deleteReview(ReviewVO vo) {
		
		System.out.println("리뷰 삭제 요청");
		System.out.println("gdsNo : " +vo.getGdsNo());
		service.deleteReview(vo.getReviewNo());
		
		return "redirect:/goods/"+vo.getGdsNo();
	}
	
	@GetMapping("/reviewWrite")
	public String reviewWrite(Model model) {
		
		return "review/reviewWrite";
	}
	
	
	
}
