package com.fw.shopping.member.service;

import java.util.List;

import com.fw.shopping.admin.model.SearchVO;
import com.fw.shopping.member.model.MemberVO;

public interface IMemberService {

	void addMember(MemberVO member);
	
	void deleteMember(int userNo);
	
	MemberVO showMemInfo(int userNo);
	
	void modifyMember(MemberVO member);
	
	List<MemberVO> getMemberList(SearchVO search);
}
