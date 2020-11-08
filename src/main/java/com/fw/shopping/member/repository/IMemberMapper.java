package com.fw.shopping.member.repository;

import java.util.List;

import com.fw.shopping.admin.model.SearchVO;
import com.fw.shopping.member.model.MemberVO;

public interface IMemberMapper {

	void addMember(MemberVO member);
	
	void deleteMember(int userNo);
	
	MemberVO showMemInfo(int userNo);
	
	void modifyMember(MemberVO member);
	
	List<MemberVO> getMemberList(SearchVO search);
	
}
