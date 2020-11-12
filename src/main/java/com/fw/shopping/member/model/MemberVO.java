package com.fw.shopping.member.model;

import java.util.Date;

public class MemberVO {
	
	private Integer userNo; // pk
	private Integer adminVerify;
	private String userEmail;
	private String userPw;
	private String userName;
	private String userPhone;
	private String userAddr1;
	private String userAddr2;
	private Date userRegDate;

	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public Integer getAdminVerify() {
		return adminVerify;
	}
	public void setAdminVerify(Integer adminVerify) {
		this.adminVerify = adminVerify;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddr1() {
		return userAddr1;
	}
	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}
	public String getUserAddr2() {
		return userAddr2;
	}
	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}
	public Date getUserRegDate() {
		return userRegDate;
	}
	public void setUserRegDate(Date userRegDate) {
		this.userRegDate = userRegDate;
	}

	
	@Override
	public String toString() {
		return "MemberVO [userNo=" + userNo + ", adminVerify=" + adminVerify + ", userEmail=" + userEmail + ", userPw="
				+ userPw + ", userName=" + userName + ", userPhone=" + userPhone + ", userAddr1=" + userAddr1
				+ ", userAddr2=" + userAddr2 + ", userRegDate=" + userRegDate + "]";
	}

	
	
	
}
