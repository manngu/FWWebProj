package com.fw.shopping.admin.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fw.shopping.commons.PageVO;
import com.fw.shopping.faq.model.FaqVO;
import com.fw.shopping.faq.service.IFaqService;
import com.fw.shopping.notice.service.INoticeService;

@Controller
@RequestMapping("/admin/faqs")
public class AdminFaqController {
	
	@Inject
	IFaqService faqService;

	
	//faq 등록화면 요청
	@GetMapping("/post")
	public String faqPost() {
		return "admin/board/faqPost";
	}
	
	
	//faq 등록
	@PostMapping("/post")
	public String faqPost(FaqVO faq, RedirectAttributes ra) {
		faqService.addFaq(faq);
		ra.addFlashAttribute("msg", "regSuccess");
		return "redirect:/faq/list";
	}
	
	//게시물 수정 페이지 요청
	@GetMapping("/modify")
	public String modify(FaqVO faq, Model model
			, @ModelAttribute("p") PageVO paging) {
		System.out.println("parameter(글 번호): " + faq.getFaqNo());
		FaqVO vo = faqService.getFaqInfo(faq.getFaqNo());
		System.out.println("Result Data: " + vo);
		model.addAttribute("faqInfo", vo);
		
		return "admin/board/faqModify";
	}
	
	//게시물 수정 요청
	@PostMapping("/modify")
	public String modify(FaqVO faq, RedirectAttributes ra) {
		System.out.println("parameter(게시글): " + faq);
		faqService.modifyFaq(faq);
		
		ra.addFlashAttribute("msg", "modSuccess");	
		return "redirect:/faq/content/" + faq.getFaqNo();
	}
	
	
	//게시물 삭제 처리 요청
	@PostMapping("/delete")
	public String remove(Integer faqNo, PageVO paging,
					RedirectAttributes ra) {

		System.out.println("URL: /faq/delete => POST");
		System.out.println("parameter(글 번호): " + faqNo);
		faqService.deleteFaq(faqNo);
		ra.addFlashAttribute("msg", "delSuccess");
		 // .addAttribute("page", paging.getPage())
		//  .addAttribute("countPerPage", paging.getCountPerPage());

		return "redirect:/faq/list";
	}
	

	


	
	

}
