package com.fw.shopping.notice.model;

import java.util.Date;

public class NoticeVO {
	
	private Integer NoticeNo; // pk
	private String  NoticeTitle;
	private String  NoticeContent;
	private Date NoticeRegDate;

	
	public Integer getNoticeNo() {
		return NoticeNo;
	}
	public void setNoticeNo(Integer noticeNo) {
		NoticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return NoticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		NoticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return NoticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		NoticeContent = noticeContent;
	}
	public Date getNoticeRegDate() {
		return NoticeRegDate;
	}
	public void setNoticeRegDate(Date noticeRegDate) {
		NoticeRegDate = noticeRegDate;
	}

	@Override
	public String toString() {
		return "NoticeVO [NoticeNo=" + NoticeNo + ", NoticeTitle=" + NoticeTitle + ", NoticeContent=" + NoticeContent
				+ ", NoticeRegDate=" + NoticeRegDate + "]";
	}



}

