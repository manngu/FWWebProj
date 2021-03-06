package com.fw.shopping.goods.service;

import java.util.List;

import com.fw.shopping.admin.model.SearchVO;
import com.fw.shopping.admin.model.SortingVO;
import com.fw.shopping.goods.model.GoodsVO;

public interface IGoodsService {

	//상품	등록	: 
	void addGoods(GoodsVO gds);
	
	//수정	: 
	void modifyGoods(GoodsVO gds);
	
	//정보조회	: 
	GoodsVO getGdsInfo(int gdsNo);
	
	//삭제	: 
	void deleteGoods(int gdsNo);	 //실제 삭제 쿼리x. visibility 수정
	
	//목록조회	: 
	List<GoodsVO> getGoodsList(SearchVO search, SortingVO sort); //검색, 정렬
}
