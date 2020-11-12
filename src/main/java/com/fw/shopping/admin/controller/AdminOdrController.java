package com.fw.shopping.admin.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.service.IOrderService;

@Controller
@RequestMapping("/admin/orders")
public class AdminOdrController {
	
	@Inject
	IOrderService odrService;
	
	
	//주문 리스트 조회
	@GetMapping
	public String orderMain(Model model) {
		List<OrderDetailVO> list = odrService.getAdminOdrList();
		model.addAttribute("list", list);
		return "admin/adminOrderMain";
	}
	
	//취소/교환/환불 리스트
	@GetMapping("/problems")
	public String problemList(Model model) {
		List<OrderDetailVO> list = odrService.getAdminOdrList();
		model.addAttribute("list", list);
		
		return "admin/odrProbList";
	}
	
	//취소/교환/환불 승인
	@GetMapping("/problems/admit/{orderDetailNo}")
	public String probAdmit(@PathVariable("orderDetailNo") int orderDetailNo) {
		odrService.admitProb(orderDetailNo);
		return "redirect:/admin/orders/problems";
	}
	
	//취소/교환/환불 거부
	@GetMapping("/problems/reject/{orderDetailNo}")
	public String probReject(@PathVariable("orderDetailNo") int orderDetailNo) {
		odrService.rejectProb(orderDetailNo);
		return "redirect:/admin/orders/problems";
	}
	
	//송장번호 등록 페이지
	@GetMapping("/invoice")
	public String invoicePage() {
		return "admin/enrollInvoice";
	}
	
	//송장번호 등록
	@PostMapping("/invoice")
	public String enrollInvoice(@Param("orderDetailNo") int orderDetailNo, @Param("invoiceNo")int invoiceNo) {
		odrService.enrollInvoice(orderDetailNo, invoiceNo);		
		return "redirect:/admin/orders";
		
	}
	
	
}
