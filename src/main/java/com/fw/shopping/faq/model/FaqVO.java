package com.fw.shopping.faq.model;

import java.util.Date;

public class FaqVO {
	
	private Integer faqNo; // pk
	private String  faqTitle;
	private String  faqContent;
	private Date faqRegDate;
	
		
	public Integer getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(Integer faqNo) {
		this.faqNo = faqNo;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public Date getFaqRegDate() {
		return faqRegDate;
	}
	public void setFaqRegDate(Date faqRegDate) {
		this.faqRegDate = faqRegDate;
	}

	@Override
	public String toString() {
		return "FaqVO [faqNo=" + faqNo + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent + ", faqRegDate="
				+ faqRegDate + "]";
	}

	

	
}
