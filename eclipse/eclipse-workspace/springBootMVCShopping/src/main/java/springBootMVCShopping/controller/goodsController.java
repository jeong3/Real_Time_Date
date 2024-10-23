package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.GoodsCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.goods.EmpNumSelectService;
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
	public String goodsList(Model model) {
		goodsListService.execute(model);
		return "thymeleaf/goods/goodsList";
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
	@PostMapping("goodsRegist")
	public String goodsRegist(GoodsCommand goodsCommand) {
		goodsRegistService.execute(goodsCommand);
		return "redirect:goodsList";
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
	@GetMapping("goodsDelete")
	public String goodsDelete(String goodsNum) {
		goodsDeleteService.execute(goodsNum);
		
		return "redirect:goodsList";
	}
	
}
