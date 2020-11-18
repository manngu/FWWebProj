package com.fw.shopping.category.repository;

import java.util.List;

import com.fw.shopping.category.model.CategoryVO;

public interface ICategoryMapper {
	
	List<CategoryVO> getCateList();
	
	List<CategoryVO> getJoinCateList();
	
	List<CategoryVO> getSupCateList();
	
	List<CategoryVO> getSubCateList();
	
	void addCategory(CategoryVO cat);

	CategoryVO getCateInfo(int cateCode);

	void addCategory(int cateRef, CategoryVO cat);
	
	void deleteCategory(int cateNo);

	void modifyCategory(CategoryVO cat);
	
	List<CategoryVO> getCateListByRef(int cateRef);


	


}
