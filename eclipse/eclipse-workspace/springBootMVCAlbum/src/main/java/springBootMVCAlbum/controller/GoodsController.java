package springBootMVCAlbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.GoodsCommand;
import springBootMVCAlbum.service.AutoNumService;
import springBootMVCAlbum.service.goods.GoodsDeleteService;
import springBootMVCAlbum.service.goods.GoodsDetailService;
import springBootMVCAlbum.service.goods.GoodsListService;
import springBootMVCAlbum.service.goods.GoodsRegistService;
import springBootMVCAlbum.service.goods.GoodsUpdateService;

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
	@Autowired 
	GoodsUpdateService goodsUpdateService;
	@Autowired
	GoodsDeleteService goodsDeleteService;
	
	@RequestMapping("goodsList")
	public String goodsList(String searchWord,
			String category, Model model) {
		System.out.println(category+"컨트롤러");
		goodsListService.execute(searchWord, category, model);
		
		return "thymeleaf/goods/goodsList";
	}
	@GetMapping("goodsItem")
	public String goodsItem(String searchWord,
			String category, Model model) {
		System.out.println(category+"컨트롤러");
		goodsListService.execute(null, null, model);
		
		return "thymeleaf/goods/goodsItem";
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
	@GetMapping("goodsUpdate")
	public String goodsUpdate(String goodsNum, Model model) {
		System.out.println(goodsNum+"goooooodsNum");
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsUpdate";
	}
	@PostMapping("goodsUpdate")
	public String goodsUpdate(GoodsCommand goodsCommand, HttpSession session) {
		goodsUpdateService.execute(goodsCommand, session);
		return "redirect:/";
	}
	@GetMapping("goodsDelete")
	public String goodsDelete(String goodsNum) {
		goodsDeleteService.execute(goodsNum);
		return "redirect:/";
	}
}	
