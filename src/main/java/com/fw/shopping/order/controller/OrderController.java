package com.fw.shopping.order.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fw.shopping.cart.model.CartJoinVO;
import com.fw.shopping.cart.service.ICartService;
import com.fw.shopping.member.model.MemberVO;
import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.model.OrderVO;
import com.fw.shopping.order.service.IOrderService;


@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Inject
	private IOrderService orderService;
	@Inject
	private ICartService cartService;
	
	
	//장바구니에서 장바구니 정보 가져오기
	@GetMapping("/orderInfo")
	public String orderinfo(Model model, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("user");
		List<CartJoinVO> cartList = new ArrayList();
		
		if (member != null) {
			cartList = cartService.getCartList(member.getUserNo());
		}
	
		
		System.out.println("URL: /order/orderInfo => GET");
		System.out.println("Result Data: " + cartList);
		model.addAttribute("cartList", cartList);
		
		return "order/orderInfo";
	}
	
	//내 주문 정보 생성
    @PostMapping("/myorder/{userNo}")
    public void myorder(@PathVariable("userNo") Integer userNo) {
       
       //call order api and get order id
       String orderId = "1111";
       List<CartJoinVO> cartList = new ArrayList();
       cartList = cartService.getCartList(userNo);
       for(CartJoinVO cartVo : cartList) {
          OrderDetailVO orderDetailVO = new OrderDetailVO();
          orderDetailVO.setOrderStock(cartVo.getCartStock());
          orderDetailVO.setGdsNo(cartVo.getGdsNo());
          orderDetailVO.setOrderId(orderId);
          orderDetailVO.setOptionNo(cartVo.getOptionNo());
          orderService.addOdrDetail(orderDetailVO);
       }
 }
    
  
  //결제 api로 넘어가기 전에 orderInfo에서 수정된 값까지 해서 orderVO 전부 처리
  	@PostMapping("/orders")
  	public String order(OrderVO order, HttpSession session) {
  		
  		OrderVO vo = (OrderVO)session.getAttribute("order");
  		System.out.println("받아온 세션 : "+vo);
  		
  		//주문번호생성
  		Date now = new Date();
  		SimpleDateFormat tool = new SimpleDateFormat("yyyyMMdd");
  		String date = tool.format(now);		
  		String random = ""+(int)Math.floor(Math.random()*(9999-1000+1)+1000);
  		String orderId = date+random;
  		
  		System.out.println("date:"+date+", random:"+random);
  		System.out.println("orderId:"+orderId);		
  		order.setOrderId(orderId);
  		
  		
  		session.setAttribute("order", order); //같은 이름으로 추가했을 때 덮어씌워진다는 가정하에...
  		
  		System.out.println("세션; 주문서 정보: "+session.getAttribute("order"));
  		
  		
  		//결제 api가 어떻게 되는 지 몰라 여기까지 작성했습니다.
  		//중간중간있는 sysout은 값체크용이니 주석처리하셔도 됩니다.
  		//만약에 regdate까지 필요하다면 이 메서드에서(컨트롤러를 옮긴 후에) service를 통해 insert를 진행해 빼오시면 됩니다.
  		
  		return "order/payment";
  	}
  	
  	@GetMapping("/orderComplete")
  	public String orderComplete(HttpSession session) {
  		
  		OrderVO order = (OrderVO)session.getAttribute("order");
  		System.out.println("order 정보 :"+order);
  		
  		orderService.addOrder(order);
  		
  		
  		session.removeAttribute("order");
 
  		return "redirect:/mypage";
  	}

}
