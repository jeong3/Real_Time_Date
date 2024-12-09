package springBootMVCAlbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootMVCAlbum.domain.GoodsDTO;
import springBootMVCAlbum.domain.ReviewDTO;
import springBootMVCAlbum.mapper.ReviewInquiryMapper;
import springBootMVCAlbum.service.review.ChoiceGoodsService;

@Controller
public class ReviewController {
	@Autowired
	ReviewInquiryMapper reviewMapper;
	@Autowired
	ChoiceGoodsService choiceGoodsService;
	
	@GetMapping("/reviews/choiceGoods")
	public String choiceGoods(@RequestParam String purchaseNum,Model model) {
		List<String> goodsNums = reviewMapper.choiceGoods(purchaseNum);
		System.out.println("goodsNums"+goodsNums);
		List<GoodsDTO> list = reviewMapper.goodsSelect(goodsNums);
		model.addAttribute("list", list);
		model.addAttribute("purchaseNum", purchaseNum);
		return "thymeleaf/reviews/choiceGoods";
	}
	@GetMapping("/reviews/choiceGoodsUp")
	public String choiceGoodsUp(@RequestParam String purchaseNum,Model model) {
		List<String> goodsNums = reviewMapper.choiceGoods(purchaseNum);
		System.out.println("goodsNums"+goodsNums);
		List<GoodsDTO> list = reviewMapper.goodsSelect(goodsNums);
		model.addAttribute("list", list);
		model.addAttribute("purchaseNum", purchaseNum);
		return "thymeleaf/reviews/choiceGoodsUp";
	}
	
	
	@GetMapping("/reviews/reviewRegist")
	public String reviewRegist(@RequestParam String purchaseNum, @RequestParam String goodsNum, Model model) {
		model.addAttribute("purchaseNum", purchaseNum);
		model.addAttribute("goodsNum", goodsNum);
		return "thymeleaf/reviews/reviewRegist";
	}
	@GetMapping("/reviews/reviewUpdate")
	public String reviewUpdate(@RequestParam String purchaseNum, @RequestParam String goodsNum, Model model) {
		System.out.println("purN"+purchaseNum);
		ReviewDTO dto = reviewMapper.ReviewSelect(purchaseNum, goodsNum);
		System.out.println("dto임"+dto);
		model.addAttribute("dto", dto);
		return "thymeleaf/reviews/reviewUpdate";
	}
	
	
}
