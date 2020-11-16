package com.fw.shopping.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fw.shopping.member.model.MemberVO;
import com.fw.shopping.member.service.MemberService;

@Controller
@RequestMapping("/member") //  /shopping/member/...
public class MemberController {

	@Autowired
	private MemberService service;
	
	// index_after a href("/index")에서 로그아웃 버튼 누르면 /index 요청
	@GetMapping("/index") // 로그인 화면 이동
	public String index() {
		return "member/login";
	}	
	
	// index_before a href ("/login/")에서 회원가입 버튼 누르면 signup이 요청되고
	@GetMapping("/signup") // signup을 요청하면 signup.jsp를 실행
	public String signup() {
		return "member/signup";
	}

	// signup.jsp form action ("/join")에서 회원가입 버튼 누르면 DB에 값 넘어감 
	@PostMapping("/join") // 값이 넘어가면서 /join을 요청하면 index_after.jsp를 실행
	public String join(MemberVO vo, Model model, String userPw2) throws Exception {
		String join_result;
		
		if(vo.getUserName().equals("") || vo.getUserPw().equals("") ||
			vo.getUserAddr1().equals("") || vo.getUserPhone().equals("") ||
			vo.getUserEmail().equals("")) {
			join_result = "blank";
		} else if(!vo.getUserPw().equals(userPw2)) {
			join_result = "nomatched";
		} else {
			service.addMember(vo); // 정보 삽입 (void)
			join_result = "success";
		}
		model.addAttribute("join_result", join_result);
		return "member/check";
	} 
	
	@GetMapping("/show") // 회원정보조회
	public String show(MemberVO vo) {
		return "member/show";
	}
	
	@GetMapping("/modify") // 회원정보수정
	public String modify() {
		return "member/modify";
	}
	
	@PostMapping("/modify") // 회원정보수정
	public String modify(MemberVO vo, HttpSession session) throws Exception {
		System.out.println("수정정보 post 요청: " + vo);
		service.modifyMember(vo);
		MemberVO member = service.checkMember(vo.getUserEmail());
		session.removeAttribute("user"); // 로그아웃
		MemberVO session1 = (MemberVO)session.getAttribute("user");
		session.setAttribute("user", member);
		MemberVO session2 = (MemberVO)session.getAttribute("user");
		return "member/show";
	}
	
	@GetMapping("/withdraw")
	public String withdraw() {
		return "member/withdraw";
	}
	
	@PostMapping("/withdraw")
	public String withdraw(MemberVO vo, Model model, HttpSession session) throws Exception {
		String delete_result;
		System.out.println("vo: " + vo);
		MemberVO member = service.showMemInfo(vo.getUserNo());

		if(member.getUserPw().equals(vo.getUserPw())) {
			service.deleteMember(vo);
			delete_result = "success";
			session.removeAttribute("user");
			session.invalidate();
		} else {
			delete_result = "failed";
		}
		System.out.println("delete_result: " + delete_result);
		model.addAttribute("delete_result", delete_result); // result 값 넘김
		return "member/check";
	}
	
	// index_before.jsp a href("/login")에서 로그인하기 버튼 누르면 실행됨
	@GetMapping("/login") // /login요청을 받으면 login.jsp 실행
	public String login(MemberVO vo) {
		return "member/login"; 
	}
	
	// login.jsp form action("/login") 에서 로그인 버튼 누르면 실행됨 
	@PostMapping("/login") // /login을 요청하면 loginSuccess.jsp 실행
	public String loginCheck(MemberVO vo, Model model, HttpSession session) throws Exception {
		String login_result;
		MemberVO id = service.checkMember(vo.getUserEmail());
		
		if (id == null) { // 아이디체크
			login_result = "null";
		} else {
			if(vo.getUserPw().equals(id.getUserPw())) {
				session.setAttribute("user", id); // 세션
				session.setMaxInactiveInterval(20*60);
				MemberVO session1 = (MemberVO)session.getAttribute("user");
				login_result = "success"; // login 성공
			} else {
				login_result = "incorrectPw"; // 비밀번호 틀림
			}
			
		}
		model.addAttribute("login_result", login_result); // result 값 넘김
		return "member/check"; // 로그인 상태
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("user");
		session.invalidate();
		
		return "redirect:/";
	}
	

}
