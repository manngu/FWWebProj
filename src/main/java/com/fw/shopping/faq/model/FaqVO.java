package com.fw.shopping.faq.model;

import java.util.Date;

public class FaqVO {
	
	private Integer FaqNo; // pk
	private String  FaqTitle;
	private String  FaqContent;
	private Date FaqRegDate;

	public Integer getFaqNo() {
		return FaqNo;
	}
	public void setFaqNo(Integer faqNo) {
		FaqNo = faqNo;
	}
	public String getFaqTitle() {
		return FaqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		FaqTitle = faqTitle;
	}
	public String getFaqContent() {
		return FaqContent;
	}
	public void setFaqContent(String faqContent) {
		FaqContent = faqContent;
	}
	
	public Date getFaqRegDate() {
		return FaqRegDate;
	}
	
	public void setFaqRegDate(Date faqRegDate) {
		FaqRegDate = faqRegDate;
	}
	
	@Override
	public String toString() {
		return "FaqVO [FaqNo=" + FaqNo + ", FaqTitle=" + FaqTitle + ", FaqContent=" + FaqContent + "]";
	}

	
}
