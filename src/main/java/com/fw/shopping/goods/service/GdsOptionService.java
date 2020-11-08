package com.fw.shopping.goods.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fw.shopping.admin.model.SearchVO;
import com.fw.shopping.admin.model.SortingVO;
import com.fw.shopping.goods.model.GdsOptionVO;
import com.fw.shopping.goods.model.GoodsVO;

@Service
public class GdsOptionService implements IGdsOptionService {

	@Override
	public void addGoods(GoodsVO gds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyGoods(GoodsVO gds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GoodsVO getGdsInfo(int gdsNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGoods(int gdsNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GoodsVO> getGoodsList(SearchVO search, SortingVO sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGdsOpt(int gdsRef, GdsOptionVO option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyGdsOpt(GdsOptionVO option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGdsOpt(int optionNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GdsOptionVO> getOptionList(int gdsRef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GdsOptionVO getOptionInfo(int optionNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
