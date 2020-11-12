package com.fw.shopping.option.service;

import java.util.List;

import com.fw.shopping.option.model.OptionVO;

public interface IOptionService {
	
	List<OptionVO> getOptionList(int gdsNo);
	
	void modifyGdsOpt(OptionVO option);
	
	

	void addGdsOpt(int gdsRef, OptionVO option);

	
	void deleteGdsOpt(int optionNo);
	

	
	OptionVO getOptionInfo(int optionNo);
}
