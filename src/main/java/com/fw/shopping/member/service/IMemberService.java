package com.fw.shopping.member.service;

import java.util.List;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.member.model.MemberVO;

public interface IMemberService {

	void addMember(MemberVO member) throws Exception; // 회원가입
	
	void deleteMember(MemberVO vo) throws Exception; // 회원탈퇴
	
	MemberVO showMemInfo(int userNo) throws Exception; // 회원정보조회
	
	void modifyMember(MemberVO member) throws Exception; // 회원정보수정
	
	MemberVO checkMember(String userEmail) throws Exception; // 로그인체크
	
	List<MemberVO> getMemberList(SearchVO search) throws Exception; // 관리자
}
