package com.fw.shopping.category.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fw.shopping.category.model.CategoryVO;
import com.fw.shopping.category.repository.ICategoryMapper;

@Service
public class CategoryService implements ICategoryService {

	@Inject
	ICategoryMapper mapper;
	
	@Override
	public List<CategoryVO> getCateList() {

		return mapper.getCateList();
	}
	
	@Override
	public List<CategoryVO> getJoinCateList() {
		return mapper.getJoinCateList();
	}
	
	@Override
	public List<CategoryVO> getSupCateList() {
		return mapper.getSupCateList();
	}
	
	@Override
	public List<CategoryVO> getSubCateList() {
		return mapper.getSubCateList();
	}
	
	@Override
	public void addCategory(CategoryVO cat) {
		mapper.addCategory(cat);
		
	}
	
	@Override
	public void deleteCate(int cateNo) {
		mapper.deleteCate(cateNo);
		
	}
	
	
	
	@Override
	public CategoryVO getCateInfo(int cateCode) {

		return null;
	}



	@Override
	public void modifyCate(CategoryVO cat) {

		
	}




}
