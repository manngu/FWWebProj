package com.fw.shopping.faq.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fw.shopping.commons.PageCreator;
import com.fw.shopping.commons.PageVO;
import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.faq.model.FaqVO;
import com.fw.shopping.faq.service.IFaqService;
import com.fw.shopping.member.model.MemberVO;

@Controller
@RequestMapping("/faq")
public class FaqController {

	@Inject
	private IFaqService faqService;

	
	@GetMapping("/write")
	public String write(HttpSession session, RedirectAttributes ra) {
		System.out.println("URL: /faq/write => GET");
		
		return "faq/write";
	}
	
	//Faq 목록 조회
	@GetMapping("/list")
	public String list(SearchVO search, Model model) {
		
		String condition = search.getCondition();
		
		System.out.println("URL: /faq/list GET -> result: ");
		System.out.println("parameter(페이지번호): " + search.getPage() + "번");
		System.out.println("검색 조건: " + condition);
		System.out.println("검색어: " + search.getKeyword());
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		
		List<FaqVO> faqList = faqService.getFaqList(search);
		pc.setTotalCount(faqService.countFaqs(search));
	
		model.addAttribute("faq", faqList);
		model.addAttribute("pc", pc);

		return "faq/list";
	}
	
	//FAQ 상세 조회 요청
	@GetMapping("/content/{faqNo}")
	public String content(@PathVariable Integer faqNo, Model model
			, @ModelAttribute("p") SearchVO paging
			, HttpSession session) {
		System.out.println("URL: /faq/faqContent => GET");
		System.out.println("parameter(글 번호): " + faqNo);
		FaqVO vo = faqService.getFaqInfo(faqNo);
		System.out.println("Result Data: " + vo);
		model.addAttribute("faq", vo);
		Object adminVerifyObj = session.getAttribute("admin_verify");
		if (adminVerifyObj != null) {
			model.addAttribute("admin_verify",(Integer)adminVerifyObj);
		}
		return "faq/content";
	}


	
	
}
