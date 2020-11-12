package com.fw.shopping.goods.service;

import java.util.List;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.commons.SortVO;
import com.fw.shopping.goods.model.GdsJoinCateVO;
import com.fw.shopping.goods.model.GoodsVO;

public interface IGoodsService {
	
	//관리자목록조회
	List<GdsJoinCateVO> getAdminGdsList();
	
	//정보조회	: 
	GoodsVO getGdsInfo(int gdsNo);

	//수정	: 
	void modifyGoods(GoodsVO gds);
	
	//삭제	: 
	void deleteGoods(int gdsNo);	 //실제 삭제 쿼리x. visibility 수정
	
	//상품	등록	: 
	void addGoods(GoodsVO gds);
	


	

	
	//목록조회	: 
	List<GoodsVO> getGoodsList(SearchVO search, SortVO sort); //검색, 정렬
	

}
