package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.GoodsCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.EmpNumSelectService;
import springBootMVCShopping.service.goods.GoodsDeleteService;
import springBootMVCShopping.service.goods.GoodsDetailService;
import springBootMVCShopping.service.goods.GoodsListService;
import springBootMVCShopping.service.goods.GoodsRegistService;
import springBootMVCShopping.service.goods.GoodsUpdateService;

@Controller
@RequestMapping("goods")
public class goodsController {
	@Autowired
	GoodsRegistService goodsRegistService;
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	EmpNumSelectService empNumSelectService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsUpdateService goodsUpdateService;
	@Autowired
	GoodsDeleteService goodsDeleteService;
	
	
	
	@GetMapping("goodsList")
	public String goodsList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "searchWord", required = false) String searchWord
			, Model model) {
		goodsListService.execute(page, searchWord, model);
		return "thymeleaf/goods/goodsList";
	}
	@GetMapping("goodsWrite")
	public String form() {
		
		return "thymeleaf/goods/goodsWrite";
	}
	
	@GetMapping("goodsRegist")
	public String goodsRegist(Model model, HttpSession session ) {
		String autoNum = autoNumService.execute("goods_", "goods_num", 7, "goods");
		String empNum = empNumSelectService.execute(session,  model);
		GoodsCommand goodsCommand = new GoodsCommand();
		goodsCommand.setGoodsNum(autoNum);
		goodsCommand.setEmpNum(empNum);
		model.addAttribute("goodsCommand", goodsCommand);
		return "thymeleaf/goods/goodsForm";
	}
	@RequestMapping("goodsRegist")
	public String goodsRegist(@Validated GoodsCommand goodsCommand , BindingResult result
			, HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}
		goodsRegistService.execute(goodsCommand);
		return "thymeleaf/goods/goodsRedirect";
	}
	@GetMapping("goodsDetail")
	public String goodsDetail(String goodsNum,  Model model) {
		
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsDetail";
	}
	@GetMapping("goodsUpdate")
	public String goodsUpdate(String goodsNum,  Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsUpdate";
	}
	@PostMapping("goodsUpdate")
	public String goodsUpdate(GoodsCommand goodsCommand , Model model, HttpSession session) {
		String empNum = empNumSelectService.execute(session,  model);
		goodsCommand.setUpdateEmpNum(empNum);
		goodsUpdateService.execute(goodsCommand);
		return "redirect:goodsDetail?goodsNum="+goodsCommand.getGoodsNum();
	}
	@RequestMapping("goodsDelete")
	public String goodsDelete(@RequestParam("nums") String goodsNums []) {
		goodsDeleteService.execute(goodsNums);
		return "redirect:goodsList";
	}
	
}
