package com.fw.shopping.goods.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fw.shopping.goods.model.GoodsVO;
import com.fw.shopping.goods.service.IGoodsService;
import com.fw.shopping.qna.model.QnaVO;
import com.fw.shopping.qna.service.IQnaService;
import com.fw.shopping.review.model.ReviewVO;
import com.fw.shopping.review.service.IReviewService;


@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private IGoodsService gdsService;
	
	@Autowired
	private IReviewService reviewService;
	
	@Autowired
	private IQnaService qnaService;
	
	@GetMapping("/topList")
	public String topList(int gdsType, Model model) {
		
		List<GoodsVO> vo = gdsService.getGoodsList(gdsType);
		System.out.println("상의 리스트 요청 들어옴 : GET" + vo);
		
		model.addAttribute("list", vo);
		
		return "goods/topList";
	}
	
	@GetMapping("/{gdsNo}")
	public String list(@PathVariable int gdsNo, Model model) {		
		
		GoodsVO gdsVo = gdsService.getGdsInfo(gdsNo);
		
		System.out.println("요청 상품 정보 : "+ gdsVo);

		model.addAttribute("info",gdsVo);
		
		List<ReviewVO> List = reviewService.getReviewList(gdsNo);
		List<ReviewVO> ReList = reviewService.getReReviewList(gdsNo);

		System.out.println(List);
		System.out.println(ReList);
		
		model.addAttribute("List", List);		
		model.addAttribute("ReList", ReList);
		
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		HashMap<Integer,String> remap = new HashMap<Integer, String>();
		
		for(ReviewVO vo : List) {
			int num = vo.getReviewNo();
			String name = reviewService.getMemberName(vo.getReviewNo());
			System.out.println("map 리뷰 번호 , name : "+num+" ,"+name);
			map.put(num, name);
		}		
		for(ReviewVO vo : ReList) {
			int num = vo.getReviewNo();
			String name = reviewService.getMemberName(vo.getReviewNo());
			System.out.println("remap 리뷰 번호 , name : "+num+" ,"+name);
			remap.put(num, name);
		}
		model.addAttribute("map", map);
		model.addAttribute("remap", remap);	
		
		// qna
		List<QnaVO> QList = qnaService.getQnaList(gdsNo);
		List<QnaVO> QReList = qnaService.getReQnaList(gdsNo);

		System.out.println(QList);
		System.out.println(QReList);
		model.addAttribute("QList", QList);		
		model.addAttribute("QReList", QReList);
		
		HashMap<Integer,String> Qmap = new HashMap<Integer, String>();
		HashMap<Integer,String> Qremap = new HashMap<Integer, String>();
		for(QnaVO vo : QList) {
			int num = vo.getQnaNo();
			String name = qnaService.getMemberName(vo.getQnaNo());
			System.out.println("map 리뷰 번호 , name : "+num+" ,"+name);
			Qmap.put(num, name);
		}		
		for(QnaVO vo : QReList) {
			int num = vo.getQnaNo();
			String name = qnaService.getMemberName(vo.getQnaNo());
			System.out.println("remap 리뷰 번호 , name : "+num+" ,"+name);
			Qremap.put(num, name);
		}
		model.addAttribute("Qmap", Qmap);
		model.addAttribute("Qremap", Qremap);
		
		
		
		return "goods/gdsInfo";
	}
	
	@GetMapping("{gdsNo}/reviewModify")
	public String Rmodify(@PathVariable int gdsNo, Model model, int modifyNo) {		
		
		list(gdsNo, model);
		System.out.println("수정 요청이 실행됨");
		model.addAttribute("modifyNo", modifyNo);
		
		return "goods/gdsInfo";
	}
	
	@GetMapping("{gdsNo}/replyWrite")
	public String replyWrite(@PathVariable int gdsNo, Model model, ReviewVO vo) {		
		ReviewVO reply = vo;
		System.out.println("reply : " + reply);
		
		if(reply.getUserNo() == null) {
			return "member/index_before";
		}
		
		list(gdsNo, model);
		System.out.println("댓글 작성 요청이 실행됨");
		model.addAttribute("ReviewVo", reply);
		
		return "goods/gdsInfo";
	}
	
	@GetMapping("{gdsNo}/QreplyWrite")
	public String QreplyWrite(@PathVariable int gdsNo, Model model, QnaVO vo) {		
		QnaVO reply = vo;
		System.out.println("reply : " + reply);
		
		if(reply.getUserNo() == null) {
			return "member/index_before";
		}
		
		list(gdsNo, model);
		System.out.println("댓글 작성 요청이 실행됨");
		model.addAttribute("QnaVo", reply);
		
		return "goods/gdsInfo";
	}
	
	@GetMapping("{gdsNo}/qnaModify")
	public String Qmodify(@PathVariable int gdsNo, Model model, int QmodifyNo) {		
		
		list(gdsNo, model);
		System.out.println("수정 요청이 실행됨");
		model.addAttribute("QmodifyNo", QmodifyNo);
		
		return "goods/gdsInfo";
	}
	
}
