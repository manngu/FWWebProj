package com.fw.shopping.admin.model;

public class SortingVO {

	private Integer sequence;
	private String condition;

	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "SortingVO [sequence=" + sequence + ", condition=" + condition + "]";
	}

	
	
	
}
