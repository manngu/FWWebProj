package com.fw.shopping.cart.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fw.shopping.cart.model.CartJoinVO;
import com.fw.shopping.cart.service.ICartService;
import com.fw.shopping.member.model.MemberVO;
import com.fw.shopping.order.model.OrderVO;



@Controller
@RequestMapping("/mypage/carts")
public class CartController {
	
	@Inject
	ICartService service;
	
	//내 카트 목록
	@GetMapping
	public String cartList(HttpSession session, Model model) {
		
		MemberVO vo = (MemberVO)session.getAttribute("user");
		List<CartJoinVO> list = service.getCartList(vo.getUserNo());
		System.out.println(list);
		model.addAttribute("list", list);
		return "mypage/cart";
		
	}
	
	
	// 카트 삭제
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public int deleteCart(@RequestParam(value = "check[]") List<String> chArr, CartJoinVO cart) throws Exception {
		
		
		int result = 0;
		int cartNo = 0;		
		
		for(String i : chArr) {
			cartNo = Integer.parseInt(i);
			cart.setCartNo(cartNo);
			service.deleteCart(cartNo);
		}
		result=1;
		return result;
	}
	
	// 카트에서 결제하기를 눌렀을 때 세션에 선택된 카트 넘버 저장하기
	@ResponseBody
	@PostMapping("/pay")
	public int orderInfo(@RequestParam(value = "check[]") List<Integer> chArr, CartJoinVO cart, HttpSession session) throws Exception {

		int result = 0;
		
		System.out.println(chArr);
		
		session.setAttribute("cartNoList", chArr);
		System.out.println("세션정보:"+session.getAttribute("cartNoList"));
		result=1;
		return result;
	}
	
	//주문자 정보입력 폼 요청
	@GetMapping("/orderinfo")
	public String orderInfo(Model model, HttpSession session) {
		
		//OrderVO가 결제api에 넣어야 할 항목이라고 생각하고 진행했습니다
		//주문번호, 유저번호, 유저이름, 배송지1, 배송지2, 전화번호, 주문가격, 주문서등록일
		//이 중에서 주문번호는 주문정보 입력시 hidden으로 처리하고, 등록일은 mapper에서 sql문 등록시 now()로 들어가므로
		//아래애서 나머지 정보를 세션에 저장된 정보를 이용해 채워넣었습니다.
		
		//주문서 객체
		OrderVO order = new OrderVO(); 
		
		//세션에서 주문자 정보 보내기 : 유저번호, 유저이름, 배송지1/2, 전화번호
		//MemberVO member= (MemberVO)session.getAttribute("member"); //저는 session에 멤버 정보가 없기때문에 일단 주석처리 했습니다~
		
		//주문가격
		List<Integer> list = (List<Integer>)session.getAttribute("cartNoList");
		System.out.println(list);
		int lastIndex = list.size()-1;	//cartNoList는 선택된 cartNo의 Integer형 배열이며, 마지막 인덱스는 합산한 금액입니다.
		System.out.println(list.get(lastIndex));
		
		/////////////////		
		//테스트용입니다~
		order.setUserNo(5);
		order.setOrderPerson("장채원");
		order.setOrderAddr1("부산시 부산진구 냉정로 289 (가야동)");
		order.setOrderAddr2("");
		order.setOrderPhone("010-8226-3423");
		order.setOrderPrice(list.get(lastIndex));
		/////////////////
		
		session.setAttribute("order", order);

		System.out.println(session.getAttribute("order"));
		model.addAttribute("od", order); //그냥 세션으로 가능하다면~ 꼭 모델 안써도 될 것 같아요~
		
		return "mypage/orderInfo";
	}
	
	
	//결제 api로 넘어가기 전에 orderInfo에서 수정된 값까지 해서 orderVO 전부 처리
	@PostMapping("/orders")
	public String order(OrderVO order, HttpSession session) {
		
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
		
		
		
		return "redirect:/mypage";
	}
	
	

	
	
	
	
		


	
	
	


}
