package com.fw.shopping.goods.repository;

import java.util.List;

import com.fw.shopping.goods.model.OptionVO;

public interface IOptionMapper{
	
	List<OptionVO> getOptionList(int gdsNo);
	
	void modifyGdsOpt(OptionVO option);

	void addGdsOpt(OptionVO option);
	
	
	void deleteGdsOpt(int optionNo);
	

	
	
	OptionVO getOptionInfo(int optionNo);

}
