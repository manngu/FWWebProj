package com.fw.shopping.option.repository;

import java.util.List;

import com.fw.shopping.option.model.OptionVO;

public interface IOptionMapper {
	
	List<OptionVO> getOptionList(int gdsNo);
	
	void modifyGdsOpt(OptionVO option);
	
	
	
	void addGdsOpt(int gdsRef, OptionVO option);
	

	
	void deleteGdsOpt(int optionNo);

	OptionVO getOptionInfo(int optionNo);

}
