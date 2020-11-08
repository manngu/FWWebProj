package com.fw.shopping.goods.service;

import java.util.List;

import com.fw.shopping.goods.model.GdsOptionVO;

public interface IGdsOptionService extends IGoodsService{

	void addGdsOpt(int gdsRef, GdsOptionVO option);
	
	void modifyGdsOpt(GdsOptionVO option);
	
	void deleteGdsOpt(int optionNo);
	
	List<GdsOptionVO> getOptionList(int gdsRef);
	
	GdsOptionVO getOptionInfo(int optionNo);
}
