package com.fw.shopping.category.service;

import java.util.List;

import com.fw.shopping.category.model.CategoryVO;

public interface ICategoryService {

	List<CategoryVO> getCateList();
	
	List<CategoryVO> getSupCateList();
	
	List<CategoryVO> getSubCateList();
	
	void addCategory(CategoryVO cat);
	
	void deleteCategory(int cateNo);
	
	List<CategoryVO> getJoinCateList();

	CategoryVO getCateInfo(int cateCode);

	void modifyCategory(CategoryVO cat);
	
	List<CategoryVO> getCateListByRef(int cateRef);



}
