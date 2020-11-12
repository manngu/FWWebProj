package com.fw.shopping.option.model;

public class OptionVO{

	private Integer optionNo; // pk 
	private Integer gdsNo;
	private String optionName;
	private Integer optionCount;
	private Integer optionAddPrice;

	public Integer getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(Integer optionNo) {
		this.optionNo = optionNo;
	}
	public Integer getGdsNo() {
		return gdsNo;
	}
	public void setGdsNo(Integer gdsNo) {
		this.gdsNo = gdsNo;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public Integer getOptionCount() {
		return optionCount;
	}
	public void setOptionCount(Integer optionCount) {
		this.optionCount = optionCount;
	}
	public Integer getOptionAddPrice() {
		return optionAddPrice;
	}
	public void setOptionAddPrice(Integer optionAddPrice) {
		this.optionAddPrice = optionAddPrice;
	}

	@Override
	public String toString() {
		return "GdsOptionVO [optionNo=" + optionNo + ", gdsNo=" + gdsNo + ", optionName=" + optionName
				+ ", optionCount=" + optionCount + ", optionAddPrice=" + optionAddPrice + "]";
	}

	
}
