package com.fw.shopping.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fw.shopping.admin.model.CategoryVO;
import com.fw.shopping.admin.repository.ICategoryMapper;

@Service
public class CategoryService implements ICategoryService {

	
	@Override
	public List<CategoryVO> getCatList() {

		return null;
	}

	@Override
	public CategoryVO getCateInfo(int cateCode) {

		return null;
	}

	@Override
	public void addCategory(int cateRef, CategoryVO cat) {

		
	}

	@Override
	public void modifyCate(CategoryVO cat) {

		
	}

	@Override
	public void deleteCate(int cateCode) {

		
	}


}
