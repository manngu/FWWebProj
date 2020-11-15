package com.fw.shopping.cart.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fw.shopping.cart.model.CartJoinVO;
import com.fw.shopping.cart.service.ICartService;

@Controller
public class TestController {
	
	@Inject
	ICartService service;
	
	@GetMapping("/mypage")
	public String mypage(Model model) {
		
		model.addAttribute("userNo", 5);
		return "mypage/mypage";
	}

	


	

}
