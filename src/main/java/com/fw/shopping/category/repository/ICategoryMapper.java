package com.fw.shopping.category.repository;

import java.util.List;

import com.fw.shopping.category.model.CategoryVO;

public interface ICategoryMapper {
	
	List<CategoryVO> getCateList();
	
	List<CategoryVO> getSupCateList();
	
	List<CategoryVO> getSubCateList();
	
	void addCategory(CategoryVO cat);

	CategoryVO getCateInfo(int cateCode);

	void addCategory(int cateRef, CategoryVO cat);
	
	void deleteCate(int cateNo);

	void modifyCate(CategoryVO cat);


	


}
