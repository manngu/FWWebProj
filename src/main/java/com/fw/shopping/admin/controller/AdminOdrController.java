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

import com.fw.shopping.commons.PageCreator;
import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.service.IOrderDetailService;
import com.fw.shopping.order.service.IOrderService;

@Controller
@RequestMapping("/admin/orders")
public class AdminOdrController {
	
	@Inject
	IOrderDetailService odrService;
	
	
	//주문 리스트 조회
	@GetMapping
	public String orderMain(Model model,SearchVO search) {
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		
		//System.out.println(pc.getPaging().getPage());
		//System.out.println(pc.getEndPage());
		//System.out.println(pc.getBeginPage());

		List<OrderDetailVO> list = odrService.getAdminOdrList(search);
		pc.setTotalCount(odrService.countOrders(search));
				
		model.addAttribute("list", list)
			.addAttribute("pc", pc);
		return "admin/order/mainList";
	}
	
	//취소/교환/환불 리스트
	@GetMapping("/problems")
	public String problemList(Model model,SearchVO search) {
		
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		
		//System.out.println(pc.getPaging().getPage());
		//System.out.println(pc.getBeginPage());
		System.out.println("sort:" + search.getSort());
		
		
		List<OrderDetailVO> list = odrService.getAdminOdrList(search);
		pc.setTotalCount(odrService.countOrders(search));
		
		model.addAttribute("list", list)
			.addAttribute("pc",pc)
			.addAttribute("sort", search.getSort());
		
		return "admin/order/problemList";
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
		return "admin/order/enrollInvoice";
	}
	
	//송장번호 등록
	@PostMapping("/invoice")
	public String enrollInvoice(@Param("orderDetailNo") int orderDetailNo, @Param("invoiceNo")int invoiceNo) {
		System.out.println(orderDetailNo);
		System.out.println(invoiceNo);
		odrService.enrollInvoice(orderDetailNo, invoiceNo);		
		return "redirect:/admin/orders";
		
	}
	
	//배송완료 입력 페이지
	@GetMapping("/deliveries")
	public String deliverCmpl(Model model,SearchVO search) {
		List<OrderDetailVO> list = odrService.getAdminOdrList(search);
		model.addAttribute("list", list);
		return "/admin/order/deliverCmpl";
	}
	
	//배송완료
	@GetMapping("/deliveries/{orderDetailNo}")
	public String deliverCompl(@PathVariable("orderDetailNo") int orderDetailNo) {
		odrService.deliverComplete(orderDetailNo);		
		
		return "redirect:/admin/orders/deliveries";
	}

	
	
	
}
