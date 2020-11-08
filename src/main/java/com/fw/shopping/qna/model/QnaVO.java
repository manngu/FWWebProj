package com.fw.shopping.qna.model;

import java.util.Date;

public class QnaVO {

	private Integer qnaNo;
	private Integer gdsNo;
	private Integer userNo;
	private Integer qnaRef;
	private Integer qnaStatus;
	private String qnaTitle;
	private String qnaContent;
	private Date qnaRegDate;

	public Integer getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(Integer qnaNo) {
		this.qnaNo = qnaNo;
	}
	public Integer getGdsNo() {
		return gdsNo;
	}
	public void setGdsNo(Integer gdsNo) {
		this.gdsNo = gdsNo;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public Integer getQnaRef() {
		return qnaRef;
	}
	public void setQnaRef(Integer qnaRef) {
		this.qnaRef = qnaRef;
	}
	public Integer getQnaStatus() {
		return qnaStatus;
	}
	public void setQnaStatus(Integer qnaStatus) {
		this.qnaStatus = qnaStatus;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public Date getQnaRegDate() {
		return qnaRegDate;
	}
	public void setQnaRegDate(Date qnaRegDate) {
		this.qnaRegDate = qnaRegDate;
	}

	@Override
	public String toString() {
		return "QnaVO [qnaNo=" + qnaNo + ", gdsNo=" + gdsNo + ", userNo=" + userNo + ", qnaRef=" + qnaRef
				+ ", qnaStatus=" + qnaStatus + ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent + ", qnaRegDate="
				+ qnaRegDate + "]";
	}
	
	

}
