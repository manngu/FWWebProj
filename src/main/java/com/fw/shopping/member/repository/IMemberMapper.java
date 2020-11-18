package com.fw.shopping.member.repository;

import java.util.List;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.member.model.MemberVO;

public interface IMemberMapper {

	void addMember(MemberVO member);
	
	void deleteMember(MemberVO member);
	
	MemberVO showMemInfo(int userNo);
	
	void modifyMember(MemberVO member);
	
	List<MemberVO> getMemberList(SearchVO search);
	
	MemberVO checkMember(String userEmail);
	
	MemberVO checkWithdraw(String userPw);
	
}
