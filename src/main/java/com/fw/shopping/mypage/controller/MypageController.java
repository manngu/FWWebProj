package com.fw.shopping.mypage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fw.shopping.member.model.MemberVO;
import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.model.OrderJoinVO;
import com.fw.shopping.order.model.OrderVO;
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

	
	
	//목록 출력
	@GetMapping
	public String mypage() {
		return "mypage/mypage";
	}
	
	
	//리뷰 목록 보기
	@GetMapping("/reviewList")
	public String reviewList(ReviewVO review, Model model, HttpSession session) {
		
		MemberVO member = (MemberVO)session.getAttribute("user");
		List<ReviewVO> reviewList = new ArrayList();
		
		System.out.println("test : " +member);
		
		if (member != null) {
			Integer userNo = member.getUserNo();
			reviewList = reviewService.getMyReviewList(userNo);
		}
		
		
		model.addAttribute("review", reviewList);
		
		return "mypage/reviewList";
	}
	
	
	//리뷰 상세 보기
	@GetMapping("/reviewCon/{reviewNo}")
	public String reviewCon(@PathVariable Integer reviewNo, Model model) {
		System.out.println("parameter(글 번호): " + reviewNo);
		
//		List<ReviewVO> reviewList = reviewService.getReviewInfo(reviewNo);
//		List<ReviewVO> rMReList = reviewService.getMyReReviewList(reviewNo);
//
//		System.out.println("Result Data: " + reviewList);
//		System.out.println("rMReList: " + rMReList);
//		
//		model.addAttribute("reviewList", reviewList);
//		model.addAttribute("rMReList", rMReList);
		
		return "mypage/reviewCon";
	}
	
	//QnA 목록 보기
	@GetMapping("/qnaList")
	public String qnaList(QnaVO qna, Model model, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("user");
		List<QnaVO> qnaList = new ArrayList();
		
		System.out.println("test : " +member);

		if (member != null) {
			Integer userNo = member.getUserNo();
			qnaList = qnaService.getMyQnaList(userNo);
		}

		
		System.out.println("qnaList : " + qnaList);
		
		model.addAttribute("qna", qnaList);

		return "mypage/qnaList";
	}

	//QnA 상세 보기
	@GetMapping("/qnaCon/{qnaNo}")
	public String qnaCon(@PathVariable Integer qnaNo, Model model) {
		System.out.println("parameter(글 번호): " + qnaNo);

		List<QnaVO> qnaList = qnaService.getQnaList(qnaNo);
		List<QnaVO> qMReList = qnaService.getMyReQnaList(qnaNo);
				
		System.out.println("Result Data: " + qnaList);
		System.out.println("qMReList : " + qMReList);

		model.addAttribute("qnaList", qnaList);
		model.addAttribute("qMReList", qMReList);

		return "mypage/qnaCon";
	}	
	
	//주문 목록 보기
	@GetMapping("/orderList")
	public String orderList(Model model, HttpSession session) {
		Object userNoObj = session.getAttribute("user_no");
		List<OrderJoinVO> orderList = new ArrayList();
		if (userNoObj != null) {
			Integer userNo = (Integer)userNoObj;
			//orderList = orderService.getMyOrderList(userNo);
		}
		
		System.out.println("URL: /mypage/orderList GET -> result: "+orderList);

		
			model.addAttribute("order", orderList);

		return "mypage/orderList";
	}
	
	//취소, 교환, 환불 요청
	@PostMapping("/orderStatus")
	public String orderList(OrderJoinVO order, RedirectAttributes ra) {
		System.out.println("URL: /mypage/orderList => POST");
		System.out.println("parameter(주문상세 번호): " + order.getOrderDetailsNo());
		//orderService.orderStatus(order);
		
		return "redirect:/mypage/orderList";
	}
	

	
}
