package com.fw.shopping.qna.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fw.shopping.member.model.MemberVO;
import com.fw.shopping.qna.model.QnaVO;
import com.fw.shopping.qna.service.IQnaService;
import com.fw.shopping.review.model.ReviewVO;

@Controller
@RequestMapping("/qna")
public class QnaController {

		@Autowired
		private IQnaService service;
		
	
		public String list(int gdsNo, Model model) {		
			
			System.out.println(gdsNo);
			
			List<QnaVO> QList = service.getQnaList(gdsNo);
			List<QnaVO> QReList = service.getReQnaList(gdsNo);
	
			System.out.println(QList);
			System.out.println(QReList);
			model.addAttribute("QList", QList);		
			model.addAttribute("QReList", QReList);
			
			HashMap<Integer,String> map = new HashMap<Integer, String>();
			HashMap<Integer,String> remap = new HashMap<Integer, String>();
			for(QnaVO vo : QList) {
				int num = vo.getQnaNo();
				String name = service.getMemberName(vo.getQnaNo());
				System.out.println("map 리뷰 번호 , name : "+num+" ,"+name);
				map.put(num, name);
			}		
			for(QnaVO vo : QReList) {
				int num = vo.getQnaNo();
				String name = service.getMemberName(vo.getQnaNo());
				System.out.println("remap 리뷰 번호 , name : "+num+" ,"+name);
				remap.put(num, name);
			}
			model.addAttribute("map", map);
			model.addAttribute("remap", remap);
			
			return "forward:/goods/"+gdsNo;
		}
		
		@GetMapping("/replyWrite")
		public String replyWrite(QnaVO vo, Model model) {
			
			//임의로 테이블에서 오더 아이디 디펄트 값  2001 로 잡아놓음
			System.out.println("reply : "+vo.getQnaRef());
			System.out.println("userNO : "+vo.getUserNo());
			System.out.println("gdsId : "+vo.getGdsNo());
			
			model.addAttribute("vo", vo);
			
			return "forward:/goods/"+vo.getGdsNo()+"/QreplyWrite";
		}
		
		@GetMapping("/question")
		public String question(QnaVO vo, Model model, HttpSession session) {
			
			Integer addQuestion = 1; //문의하기 누르면 변수 생성 후 디폴트 값 1로 설정
			
			MemberVO user = (MemberVO)session.getAttribute("user");
			System.out.println("user 세선 : "+user);
			
			if(user == null) {
				return "member/login";
			}
			
			model.addAttribute("addQuestion", addQuestion);
			model.addAttribute("question", vo);
			
			list(vo.getGdsNo(), model);
			
			return "forward:/goods/"+vo.getGdsNo();
		}
		
		@GetMapping("/insert")
		public String insert(QnaVO vo) {
					
			System.out.println("qna 작성 : "+vo);
			service.addQna(vo);
			
			return "redirect:/goods/"+vo.getGdsNo();
		}
		
		@GetMapping("/modify")
		public String modify(int qnaNo,int gdsNo, Model model) {
			
			int QmodifyNo = qnaNo;
			
			System.out.println("QmodifyNo : "+QmodifyNo);
			
			model.addAttribute("QmodifyNo", QmodifyNo);
			
			return "redirect:/goods/"+gdsNo+"/qnaModify";
		}
		
		@PostMapping("/modify")
		public String modify(QnaVO vo) {
			
			System.out.println("수정할 리뷰 정보 : "+vo);
			service.modifyQna(vo);
			
			return "redirect:/goods/"+vo.getGdsNo();
		}
		
		@PostMapping("/delete")
		public String deleteQna(QnaVO vo) {
			
			System.out.println("리뷰 삭제 요청");
			System.out.println("gdsNo : " +vo.getGdsNo());
			service.deleteQna(vo.getQnaNo());
			
			return "redirect:/goods/"+vo.getGdsNo();
		}
		
}

	

