package com.fw.shopping.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.member.model.MemberVO;
import com.fw.shopping.member.repository.IMemberMapper;

@Service
public class MemberService implements IMemberService {

	@Autowired
	private IMemberMapper mapper;
	
	@Override
	public void addMember(MemberVO vo) throws Exception { // 회원가입
		mapper.addMember(vo);
	}

	@Override
	public void deleteMember(MemberVO vo) throws Exception { // 회원탈퇴
		mapper.deleteMember(vo);
	}

	@Override
	public MemberVO showMemInfo(int userNo) throws Exception { // 회원정보조회
		MemberVO vo = mapper.showMemInfo(userNo);
		return vo;
	}

	@Override
	public void modifyMember(MemberVO vo) throws Exception { // 회원정보수정
		mapper.modifyMember(vo);
	} 

	@Override
	public List<MemberVO> getMemberList(SearchVO search) throws Exception {

		return null;
	}

	@Override
	public MemberVO checkMember(String userEmail) throws Exception { // 로그인체크
		MemberVO id = mapper.checkMember(userEmail);
		return id;
	}

}
