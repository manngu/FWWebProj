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
import com.fw.shopping.notice.model.NoticeVO;
import com.fw.shopping.notice.service.INoticeService;

@Controller
@RequestMapping("/admin/notices")
public class AdminNotiController {
	
	@Inject
	INoticeService service;
	
	//등록 페이지 요청
	@GetMapping("/post")
	public String noticePost() {
		return "admin/board/noticePost";
	}
	
	//등록 요청
	@PostMapping("/post")
	public String noticePost(NoticeVO notice, RedirectAttributes ra) {
		service.addNotice(notice);
		ra.addFlashAttribute("msg","regSuccess");
		return "redirect:/notice/list";
	}
	
	//게시물 수정 페이지 요청
	@GetMapping("/modify")
	public String modify(NoticeVO notice, Model model
			, @ModelAttribute("p") PageVO paging) {

		System.out.println("parameter(글 번호): " + notice.getNoticeNo());			
		NoticeVO vo = service.getNoticeInfo(notice.getNoticeNo());
		System.out.println("Result Data: " + vo);
		model.addAttribute("noticeInfo", vo);
		
		return "admin/board/noticeModify";
	}
	
	//게시물 수정 요청
	@PostMapping("/modify")
	public String modify(NoticeVO notice, RedirectAttributes ra) {
		System.out.println("parameter(게시글): " + notice);
		service.modifyNotice(notice);
		ra.addFlashAttribute("msg", "modSuccess");		
		return "redirect:/notice/content/" + notice.getNoticeNo();
	}
	
	
	//게시물 삭제 처리 요청
	@PostMapping("/delete")
	public String remove(Integer noticeNo, PageVO paging,
					RedirectAttributes ra) {

		System.out.println("parameter(글 번호): " + noticeNo);
		service.deleteNotice(noticeNo);
		ra.addFlashAttribute("msg", "delSuccess")
		  .addAttribute("page", paging.getPage())
		  .addAttribute("countPerPage", paging.getCountPerPage());

		return "redirect:/notice/list";
	}



}
