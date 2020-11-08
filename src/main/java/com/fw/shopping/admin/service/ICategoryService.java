package com.fw.shopping.admin.service;

import java.util.List;

import com.fw.shopping.admin.model.CategoryVO;

public interface ICategoryService {

	List<CategoryVO> getCatList();

	CategoryVO getCateInfo(int cateCode);

	void addCategory(int cateRef, CategoryVO cat);

	void modifyCate(CategoryVO cat);

	void deleteCate(int cateCode);

}
