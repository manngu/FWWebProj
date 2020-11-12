package com.fw.shopping.goods.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.commons.SortVO;
import com.fw.shopping.goods.model.GdsJoinCateVO;
import com.fw.shopping.goods.model.GoodsVO;
import com.fw.shopping.goods.repository.IGoodsMapper;

@Service
public class GoodsService implements IGoodsService {
	
	@Inject
	private IGoodsMapper mapper;
	
	
	@Override
	public List<GdsJoinCateVO> getAdminGdsList() {
		return mapper.getAdminGdsList();
	}

	@Override
	public GoodsVO getGdsInfo(int gdsNo) {
		return mapper.getGdsInfo(gdsNo);
	}

	@Override
	public void modifyGoods(GoodsVO gds) {
		mapper.modifyGoods(gds);
		
	}
	
	@Override
	public void deleteGoods(int gdsNo) {
		mapper.deleteGoods(gdsNo);
		
	}
	

	@Override
	public void addGoods(GoodsVO gds) {
		mapper.addGoods(gds);
	}


	


	
	



	@Override
	public List<GoodsVO> getGoodsList(SearchVO search, SortVO sort) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
