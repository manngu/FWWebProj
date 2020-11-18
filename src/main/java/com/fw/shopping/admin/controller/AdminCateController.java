package com.fw.shopping.admin.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fw.shopping.category.model.CategoryVO;
import com.fw.shopping.category.service.ICategoryService;

import com.fw.shopping.review.service.IReviewService;

@Controller
@RequestMapping("/admin/categories")
public class AdminCateController {
	
	@Inject
	ICategoryService catService;
	
	@Inject
	IReviewService revService;
	
	//카테고리 관리 페이지 연결
	@GetMapping
	public String categoryList(Model model) {
		List<CategoryVO> list = catService.getJoinCateList();
		List<CategoryVO> supList = catService.getSupCateList();
		model.addAttribute("list", list)
			.addAttribute("supList", supList);		
		return "admin/category/list";
	}
	
	//카테고리 등록 페이지
	@GetMapping("/post")
	public String EnrollcatePage(Model model) {
		List<CategoryVO> list = catService.getSupCateList();
		model.addAttribute("list", list);
		return "admin/category/post";
	}
	
	//카테고리 등록
	@PostMapping("/post")
	public String Enrollcategory(CategoryVO category) {
		catService.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	//카테고리 삭제
	@GetMapping("/delete/{cateNo}")
	public String DeleteCat(@PathVariable("cateNo") int cateNo) {
		catService.deleteCategory(cateNo);
		return "redirect:/admin/categories";
	}
	
	//카테고리 수정
	@PostMapping("/modify")
	public String modifyCat(CategoryVO cat) {
		System.out.println(cat);
		catService.modifyCategory(cat);
		return "redirect:/admin/categories";
		
	}


	
}
