package com.fw.shopping.qna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fw.shopping.qna.model.QnaVO;
import com.fw.shopping.qna.service.IQnaService;

@Controller
@RequestMapping("/qna")
public class QnaController {

		@Autowired
		private IQnaService service;
		
		@GetMapping("/{gdsNo}")
		public String list(@PathVariable int gdsNo, Model model) {		
			
			List<QnaVO> QList = service.getQnaList(gdsNo);
			List<QnaVO> QReList = service.getReQnaList(gdsNo);
	
			System.out.println(QList);
			System.out.println(QReList);
			model.addAttribute("QList", QList);		
			model.addAttribute("QReList", QReList);
			
			return "qna/qgdsList";
		}
		
		@GetMapping("/replyWrite")
		public String replyWrite(QnaVO vo, Model model) {
			
			//임의로 테이블에서 오더 아이디 디펄트 값  2001 로 잡아놓음
			System.out.println("reply : "+vo.getQnaRef());
			System.out.println("userNO : "+vo.getUserNo());
			System.out.println("gdsId : "+vo.getGdsNo());
			
			model.addAttribute("vo", vo);
			
			list(vo.getGdsNo(), model);
			
			return "qna/qgdsList";
		}
		
		@GetMapping("/question")
		public String question(QnaVO vo, Model model) {
			
			Integer addQuestion = 1; //문의하기 누르면 변수 생성 후 디폴트 값 1로 설정
			
			model.addAttribute("addQuestion", addQuestion);
			model.addAttribute("question", vo);
			
			list(vo.getGdsNo(), model);
			
			return "qna/qgdsList";
		}
		
		@GetMapping("/insert")
		public String insert(QnaVO vo) {
					
			System.out.println("리뷰 작성 : "+vo);
			service.addQna(vo);
			
			return "redirect:/qna/"+vo.getGdsNo();
		}
		
		@GetMapping("/modify")
		public String modify(int qnaNo,int gdsNo, Model model) {
			
			int QmodifyNo = qnaNo;
			
			System.out.println("QmodifyNo : "+QmodifyNo);
			
			model.addAttribute("QmodifyNo", QmodifyNo);
			
			list(gdsNo, model);
			
			return "qna/qgdsList";
		}
		
		@PostMapping("/modify")
		public String modify(QnaVO vo) {
			
			System.out.println("수정할 리뷰 정보 : "+vo);
			service.modifyQna(vo);
			
			return "redirect:/qna/"+vo.getGdsNo();
		}
		
		@PostMapping("/delete")
		public String deleteQna(QnaVO vo) {
			
			System.out.println("리뷰 삭제 요청");
			System.out.println("gdsNo : " +vo.getGdsNo());
			service.deleteQna(vo.getQnaNo());
			
			return "redirect:/qna/"+vo.getGdsNo();
		}
		
}

	

