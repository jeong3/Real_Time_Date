package springBootMVCAlbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.GoodsCommand;
import springBootMVCAlbum.service.AutoNumService;
import springBootMVCAlbum.service.goods.GoodsDetailService;
import springBootMVCAlbum.service.goods.GoodsListService;
import springBootMVCAlbum.service.goods.GoodsRegistService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	GoodsRegistService goodsRegistService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsDetailService goodsDetailService;
	
	@GetMapping("goodsList")
	public String goodsList(String category, Model model) {
		goodsListService.execute(category, model);
		System.out.println(category+"asdasdasd");
		return "thymeleaf/goods/goodsList";
	}
	
	@GetMapping("goodsRegist")
	public String goodsRegist(String category, Model model) {
		System.out.println(category);
		String autoNum = autoNumService.execute(category, "goods_num", 4, "goods");
		model.addAttribute("autoNum", autoNum);
		model.addAttribute("category", category);
		return "thymeleaf/goods/goodsRegist";
	}
	@PostMapping("goodsRegist")
	public String goodsRegist(GoodsCommand goodsCommand, HttpSession session) {
		goodsRegistService.execute(goodsCommand, session);
		
		return "redirect:/?category="+goodsCommand.getCategory();
	}
	@GetMapping("goodsDetail")
	public String goodsDetail(String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsDetail";
	}
}
