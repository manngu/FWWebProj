package com.fw.shopping.admin.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fw.shopping.category.model.CategoryVO;
import com.fw.shopping.category.service.ICategoryService;
import com.fw.shopping.commons.FileUploadService;
import com.fw.shopping.commons.PageCreator;
import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.commons.SortVO;
import com.fw.shopping.goods.model.GdsJoinCateVO;
import com.fw.shopping.goods.model.GoodsVO;
import com.fw.shopping.goods.model.OptionVO;
import com.fw.shopping.goods.service.IGoodsService;
import com.fw.shopping.goods.service.IOptionService;

@Controller
@RequestMapping("/admin/goods")
public class AdminGdsController {

	@Inject
	private IGoodsService gdsService;
	
	@Inject
	private IOptionService optService;
	
	@Inject
	private ICategoryService catService;
	
	@Inject
	private FileUploadService fileUploadService;
	

	
	//상품 리스트 조회
	@GetMapping
	public String goodsList(SearchVO search, Model model) {

		System.out.println("searchVO: "+search);
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);

		List<GdsJoinCateVO> list = gdsService.getAdminGdsList(search);
		pc.setTotalCount(gdsService.countGoods(search));
		

		
		model.addAttribute("list", list)
			.addAttribute("pc", pc)
			.addAttribute("catList", catService.getSubCateList());
		
		
		return "admin/goods/list";
	}
	
	//상품 상세
	@GetMapping("/{gdsNo}")
	public String gdsInfo(@PathVariable("gdsNo") int gdsNo, Model model) {
		model.addAttribute("gds", gdsService.getGdsInfo(gdsNo))
				.addAttribute("opt", optService.getOptionList(gdsNo));
		return "admin/goods/detail";
		
	}
	

	//상품 삭제(status변경)
	@GetMapping("/delete/{gdsNo}")
	public String goodsDelete(@PathVariable("gdsNo") int gdsNo) {
		gdsService.deleteGoods(gdsNo);
		return "redirect:/admin/goods";
	}
	
	
	
	//상품 등록 페이지
	@GetMapping("/post")
	public String goodsPost(Model model) {
		model.addAttribute("sup",catService.getSupCateList())
			.addAttribute("sub", catService.getSubCateList());
		
		return "admin/goods/post";
	}
	
	//서브 카테고리 동적 요청
	@ResponseBody
	@PostMapping("/getsub")
	public List<CategoryVO> getSubList(@RequestParam String c) {
		
		System.out.println("번호:"+c);
		//List<CategoryVO> sub = catService.getCateListByRef(cateRef);
		return null;
	}
	
	//상품 수정 페이지
	@GetMapping("/modify/{gdsNo}")
	public String gdsModify(@PathVariable("gdsNo") int gdsNo, Model model) {
		model.addAttribute("gds", gdsService.getGdsInfo(gdsNo))
			.addAttribute("opt", optService.getOptionList(gdsNo))
			.addAttribute("sub", catService.getSubCateList());
		return "admin/goods/modify";		
	}
		

	//상품 수정
	@PostMapping("/modify")
	public String gdsModify(GoodsVO gds,
			@RequestParam("thumb") MultipartFile thumb,
			@RequestParam("des") MultipartFile des,
			@RequestParam(value = "optionNo[]") List<Integer> noArr,
			@RequestParam(value = "optionName[]") List<String> nameArr,
			@RequestParam(value = "optionAddPrice[]") List<Integer> priceArr,
			@RequestParam(value = "optionCount[]") List<Integer> countArr) {
	
		String gdsThumbImg = fileUploadService.restore(thumb);
		String gdsDes = fileUploadService.restore(des);
		
//		System.out.println("gds:"+gds);
//		System.out.println("gdsThumb:"+gdsThumbImg);
//		System.out.println("gdsDes:"+gdsDes);
//		//옵션 배열값이 잘 넘어오는지 확인
//		for(String s:nameArr) {
//			System.out.println("name:"+s);
//		}
//		for(int s:priceArr) {
//			System.out.println("price:"+s);
//		}
//		for(int s:countArr) {
//			System.out.println("count:"+s);
//		}
		
		gds.setGdsThumbImg(gdsThumbImg);
		gds.setGdsDes(gdsDes);
		System.out.println("gds:"+gds);
		gdsService.modifyGoods(gds);
		
		OptionVO option = new OptionVO();
		
		//변경된 옵션
		for(int i=0;i<noArr.size();i++) {
			option.setOptionNo(noArr.get(i));
			option.setOptionName(nameArr.get(i));
			option.setOptionAddPrice(priceArr.get(i));
			option.setOptionCount(countArr.get(i));
			System.out.println("change option:"+option);
			
			optService.modifyGdsOpt(option);
		}
		
		OptionVO opt = new OptionVO();
		//새로 추가된 옵션
		for(int i=noArr.size(); i<nameArr.size();i++) {
			opt.setGdsNo(gds.getGdsNo());
			opt.setOptionName(nameArr.get(i));
			opt.setOptionAddPrice(priceArr.get(i));
			opt.setOptionCount(countArr.get(i));
			System.out.println("new option:" + opt);
			
			optService.addGdsOpt(opt);
		}
		
		

		return "redirect:/admin/goods/"+gds.getGdsNo();
	}
	

	//상품 등록 요청
	@RequestMapping( "/post" )
	public String goodsPost( Model model, GoodsVO gds,
					@RequestParam("thumb") MultipartFile thumb,
					@RequestParam("des") MultipartFile des,
					@RequestParam(value = "optionName[]") List<String> nameArr,
					@RequestParam(value = "optionAddPrice[]") List<Integer> priceArr,
					@RequestParam(value = "optionCount[]") List<Integer> countArr) {
		String gdsThumbImg = fileUploadService.restore(thumb);
		String gdsDes = fileUploadService.restore(des);
		
		gds.setGdsThumbImg(gdsThumbImg);
		gds.setGdsDes(gdsDes);
		gdsService.addGoods(gds);
		
		//옵션 배열값이 잘 넘어오는지 확인
//		for(String s:nameArr) {
//			System.out.println("name:"+s);
//		}
//		for(int s:priceArr) {
//			System.out.println("price:"+s);
//		}
//		for(int s:countArr) {
//			System.out.println("count:"+s);
//		}

		//가장 최근 상품의 상품번호를 가져오기
		int gdsNo = gdsService.getNewGdsInfo();
		System.out.println("gdsNo:"+gdsNo);
		
		OptionVO option = new OptionVO();
		for(int i=0;i<nameArr.size();i++) {
			option.setGdsNo(gdsNo);
			option.setOptionName(nameArr.get(i));
			option.setOptionAddPrice(priceArr.get(i));
			option.setOptionCount(countArr.get(i));
			System.out.println("optionVO: "+option);
			optService.addGdsOpt(option);		
		}
		

		return "redirect:/admin/goods";
	}

	

}