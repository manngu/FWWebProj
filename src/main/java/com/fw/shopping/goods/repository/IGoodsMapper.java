package com.fw.shopping.goods.repository;

import java.util.List;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.goods.model.GdsJoinCateVO;
import com.fw.shopping.goods.model.GoodsVO;

public interface IGoodsMapper {

	//상품	등록	: 
	void addGoods(GoodsVO gds);
	
	//수정	: 
	void modifyGoods(GoodsVO gds);
	
	//정보조회	: 
	GoodsVO getGdsInfo(int gdsNo);
	
	//삭제	: 
	void deleteGoods(int gdsNo);	 //실제 삭제 쿼리x. visibility 수정
	
	//목록조회	: 
	List<GoodsVO> getGoodsList(int gdsType); //검색, 정렬  SearchVO search, SortingVO sort 임시 제외
	
	//관리자목록조회
	List<GdsJoinCateVO> getAdminGdsList();	
	
	//신상 인덱스
	int getNewGdsInfo();
	
	
}
