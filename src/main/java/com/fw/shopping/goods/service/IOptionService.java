package com.fw.shopping.goods.service;

import java.util.List;

import com.fw.shopping.goods.model.OptionVO;

public interface IOptionService{

	List<OptionVO> getOptionList(int gdsNo);
	
	void modifyGdsOpt(OptionVO option);
	
	void addGdsOpt(OptionVO option);
	
	void deleteGdsOpt(int optionNo);

	OptionVO getOptionInfo(int optionNo);
}
