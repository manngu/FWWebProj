package com.fw.shopping.notice.controller;

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

import com.fw.shopping.admin.model.PageCreator;
import com.fw.shopping.admin.model.PageVO;
import com.fw.shopping.admin.model.SearchVO;
import com.fw.shopping.notice.model.NoticeVO;
import com.fw.shopping.notice.service.INoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {


		@Inject
		private INoticeService noticeService;

		
		@GetMapping("/write")
		public String write(HttpSession session, RedirectAttributes ra) {
			System.out.println("URL: /notice/write => GET");
			
			return "notice/write";
		}
		
		//notice 목록 조회
		@GetMapping("/list")
		public String list(SearchVO search, Model model) {
			
			String condition = search.getCondition();
			
			System.out.println("URL: /notice/list GET -> result: ");
			System.out.println("parameter(페이지번호): " + search.getPage() + "번");
			System.out.println("검색 조건: " + condition);
			System.out.println("검색어: " + search.getKeyword());
			
			PageCreator pc = new PageCreator();
			pc.setPaging(search);
			
			List<NoticeVO> noticeList = noticeService.getNoticeList(search);
			pc.setArticleTotalCount(noticeService.countNotices(search));
		
			model.addAttribute("notice", noticeList);
			model.addAttribute("pc", pc);

			return "notice/list";
		}
		
		//notice 상세 조회 요청
		@GetMapping("/content/{noticeNo}")
		public String content(@PathVariable Integer noticeNo, Model model
				, @ModelAttribute("p") SearchVO paging) {
			System.out.println("URL: /notice/noticeContent => GET");
			System.out.println("parameter(글 번호): " + noticeNo);
			NoticeVO vo = noticeService.getNoticeInfo(noticeNo);
			System.out.println("Result Data: " + vo);
			model.addAttribute("noticeInfo", vo);
			return "notice/content";
		}

		//게시물 삭제 처리 요청
		@PostMapping("/delete")
		public String remove(Integer noticeNo, PageVO paging,
						RedirectAttributes ra) {

			System.out.println("URL: /notice/delete => POST");
			System.out.println("parameter(글 번호): " + noticeNo);
			noticeService.deleteNotice(noticeNo);
			ra.addFlashAttribute("msg", "delSuccess")
			  .addAttribute("page", paging.getPage())
			  .addAttribute("countPerPage", paging.getCountPerPage());

			return "redirect:/notice/list";
		}
		
		//게시물 수정 페이지 요청
		@GetMapping("/modify")
		public String modify(Integer noticeNo, Model model
				, @ModelAttribute("p") PageVO paging) {
			System.out.println("URL: /notice/modify => GET");
			System.out.println("parameter(글 번호): " + noticeNo);
			
			NoticeVO vo = noticeService.getNoticeInfo(noticeNo);
			System.out.println("Result Data: " + vo);
			model.addAttribute("noticeInfo", vo);
			
			return "notice/modify";
		}
		
		//게시물 수정 요청
		@PostMapping("/modify")
		public String modify(NoticeVO notice, RedirectAttributes ra) {
			System.out.println("URL: /notice/modify => POST");
			System.out.println("parameter(게시글): " + notice);
			noticeService.modifyNotice(notice);
			
			ra.addFlashAttribute("msg", "modSuccess");
			
			return "redirect:/notice/content/" + notice.getNoticeNo();
		}

		

	
}
