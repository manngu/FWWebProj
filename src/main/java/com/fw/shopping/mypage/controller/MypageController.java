package com.fw.shopping.mypage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.model.OrderJoinVO;
import com.fw.shopping.order.service.IOrderDetailService;
import com.fw.shopping.order.service.IOrderService;
import com.fw.shopping.qna.model.QnaVO;
import com.fw.shopping.qna.service.IQnaService;
import com.fw.shopping.review.model.ReviewVO;
import com.fw.shopping.review.service.IReviewService;

@Controller
@RequestMapping("/mypage")
public class MypageController {

	@Autowired
	private IReviewService reviewService;
	@Autowired
	private IQnaService qnaService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IOrderDetailService orderDetailService;

	
	
	//목록 출력
	@GetMapping
	public String mypage() {
		return "/mypage";
	}
	
	
	//리뷰 목록 보기
	@GetMapping("/reviewList")
	public String reviewList(ReviewVO review, Model model) {
		List<ReviewVO> reviewList = reviewService.getMyReviewList(review.getUserNo());
		
		model.addAttribute("review", reviewList);
		
		return "mypage/reviewList";
	}
	
	
	//리뷰 상세 보기
	@GetMapping("/reviewCon/{reviewNo}")
	public String reviewCon(@PathVariable Integer reviewNo, Model model) {
		System.out.println("parameter(글 번호): " + reviewNo);
		ReviewVO vo = reviewService.getReviewInfo(reviewNo);
		System.out.println("Result Data: " + vo);
		model.addAttribute("reviewOne", vo);
		return "mypage/reviewCon";
	}
	
	//QnA 목록 보기
	@GetMapping("/qnaList")
	public String qnaList(QnaVO qna, Model model) {
		List<QnaVO> qnaList = qnaService.getMyQnaList(qna.getUserNo());
		System.out.println("qnaList : " + qnaList);
		model.addAttribute("qna", qnaList);
		
		return "mypage/qnaList";
	}

	//QnA 상세 보기
	@GetMapping("/qnaCon/{qnaNo}")
	public String qnaCon(@PathVariable Integer qnaNo, Model model) {
		System.out.println("parameter(글 번호): " + qnaNo);
		QnaVO vo = qnaService.getQnaInfo(qnaNo);
		System.out.println("Result Data: " + vo);
		model.addAttribute("reviewOne", vo);
		return "mypage/qnaCon";
	}	
	
	//주문 목록 보기
	@GetMapping("/orderList")
	public String orderList(Model model) {
		int userNo = 8;
		System.out.println("URL: /mypage/orderList GET -> result: ");

		List<OrderJoinVO> orderList = orderDetailService.getUODList(userNo);
			model.addAttribute("order", orderList);

		return "mypage/orderList";
	}
	
	//취소, 교환, 환불 요청
	@PostMapping("/orderStatus")
	public String orderList(OrderDetailVO order, RedirectAttributes ra) {
		System.out.println("URL: /mypage/orderList => POST");
		System.out.println("parameter(주문상세 번호): " + order.getOrderDetailNo());
		orderDetailService.orderStatus(order);
		
		return "redirect:/mypage/orderList";
	}
	
	
}
