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
@RequestMapping("/admin")
public class AdminDftController {
	
	@Inject
	ICategoryService catService;
	
	@Inject
	IReviewService revService;
	


	//관리자 페이지 연결
	@GetMapping
	public String adminPage() {
		return "admin/adminMain";
	}
	
	//카테고리 관리 페이지 연결
	@GetMapping("/categories")
	public String categoryList(Model model) {
		List<CategoryVO> list = catService.getCateList();
		model.addAttribute("list", list);		
		return "admin/cateList";
	}
	
	//카테고리 등록 페이지
	@GetMapping("/categoriesPost")
	public String EnrollcatePage(Model model) {
		List<CategoryVO> list = catService.getSupCateList();
		model.addAttribute("list", list);
		return "admin/catePost";
	}
	
	//카테고리 등록
	@PostMapping("/categories")
	public String Enrollcategory(CategoryVO category) {
		catService.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	//카테고리 삭제
	@GetMapping("/categoriesDelete/{cateNo}")
	public String DeleteCat(@PathVariable("cateNo") int cateNo) {
		catService.deleteCate(cateNo);
		return "redirect:/admin/categories";
	}
	

	
	
	
	
	

//	//FAQ등록 페이지 연결
//	@GetMapping("/faqPage")
//	public String faqPage() {
//		return "admin/faqWrite";
//	}
//	
//	//NOTICE등록 페이지 연결
//	@GetMapping("/noticePage")
//	public String noticePage() {
//		return "admin/noticeWrite";
//	}
	


	
}
