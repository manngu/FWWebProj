package com.fw.shopping.goods.repository;

import java.util.List;

import com.fw.shopping.goods.model.GdsOptionVO;

public interface IGdsOptionMapper extends IGoodsMapper{
	
	void addGdsOpt(int gdsRef, GdsOptionVO option);
	
	void modifyGdsOpt(GdsOptionVO option);
	
	void deleteGdsOpt(int optionNo);
	
	List<GdsOptionVO> getOptionList(int gdsRef);
	
	GdsOptionVO getOptionInfo(int optionNo);

}
