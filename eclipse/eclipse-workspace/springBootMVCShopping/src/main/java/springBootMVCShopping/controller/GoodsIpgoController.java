package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.IpgoCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.EmpNumSelectService;
import springBootMVCShopping.service.goods.GoodsListService;
import springBootMVCShopping.service.ipgo.IpgoDeleteService;
import springBootMVCShopping.service.ipgo.IpgoDetailService;
import springBootMVCShopping.service.ipgo.IpgoListService;
import springBootMVCShopping.service.ipgo.IpgoUpdateService;
import springBootMVCShopping.service.ipgo.IpgoWriteService;

@Controller
@RequestMapping("goodsIpgo")
public class GoodsIpgoController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	EmpNumSelectService empNumSelectService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	IpgoWriteService ipgoWriteService;
	@Autowired
	IpgoListService ipgoListService;
	@Autowired
	IpgoDetailService ipgoDetailService;
	@Autowired
	IpgoUpdateService ipgoUpdateService;
	@Autowired
	IpgoDeleteService ipgoDeleteService;
	
	
	@GetMapping("goodsIpgoList")
	public String ipgoList(Model model) {
		ipgoListService.execute(model);
		return "thymeleaf/goodsIpgo/ipgoList";
	}
	@GetMapping("goodsIpgo")
	public String goodsIpgo(Model model, IpgoCommand ipgoCommand, HttpSession session) {
		String autoNum = autoNumService.execute("ipgo_", "ipgo_num", 6, "goods_ipgo");
		String empNum = empNumSelectService.execute(session, model);
		ipgoCommand.setIpgoNum(autoNum);
		ipgoCommand.setEmpNum(empNum);
		model.addAttribute("ipgoCommand", ipgoCommand);
		return "thymeleaf/goodsIpgo/ipgoRegist";
	}
	@PostMapping("goodsIpgo")
	public String goodsIpgo(IpgoCommand ipgoCommand) {
		ipgoWriteService.execute(ipgoCommand);
		return "redirect:goodsIpgoList";
	}
	@GetMapping("goodsList")
	public String goodsList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "searchWord", required = false) String searchWord
			, Model model) {
		goodsListService.execute(page, searchWord, model);
		return "thymeleaf/goodsIpgo/goodsList";
	}
	@GetMapping("goodsIpgoDetail")
	public String ipgoDetail(Model model, String ipgoNum) {
		ipgoDetailService.execute(model, ipgoNum);
		return "thymeleaf/goodsIpgo/ipgoDetail";
	}
	@GetMapping("goodsIpgoUpdate")
	public String ipgoUpdate(Model model, String ipgoNum, IpgoCommand ipgoCommand) {
		ipgoDetailService.execute(model, ipgoNum);
		return "thymeleaf/goodsIpgo/ipgoUpdate";
	}
	@PostMapping("goodsIpgoUpdate")
	public String ipgoUpdate(IpgoCommand ipgoCommand) {
		ipgoUpdateService.execute(ipgoCommand);
		return "redirect:goodsIpgoDetail?ipgoNum="+ipgoCommand.getIpgoNum();
	}
	@GetMapping("goodsIpgoDelete")
	public String ipgoDelete(@RequestParam("nums") String ipgoNums []) {
		ipgoDeleteService.execute(ipgoNums);
		return "redirect:goodsIpgoList";
	}
	
}
