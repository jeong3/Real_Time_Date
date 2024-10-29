package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.IpgoCommand;
import springBootMVCShopping.domain.GoodsIpgoGoodsNameDTO;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.EmpNumSelectService;
import springBootMVCShopping.service.goods.GoodsListService;
import springBootMVCShopping.service.ipgo.IpgoDeleteService;
import springBootMVCShopping.service.ipgo.IpgoDetailService;
import springBootMVCShopping.service.ipgo.IpgoListService;
import springBootMVCShopping.service.ipgo.IpgoUpdateService;
import springBootMVCShopping.service.ipgo.IpgoWriteService;

@Controller
@RequestMapping("goods")
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
	public String ipgoList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "searchWord", required = false) String searchWord,
			Model model) {
		ipgoListService.execute(page, searchWord, model);
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
	@ResponseBody
	@PostMapping("goodsIpgo")
	public String goodsIpgo(IpgoCommand ipgoCommand) {
		ipgoWriteService.execute(ipgoCommand);
		//return "redirect:goodsIpgoList";
		return "200";
	}
	@GetMapping("goodsList1")
	public String goodsList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "searchWord", required = false) String searchWord
			, Model model) {
		goodsListService.execute(page, searchWord, model);
		return "thymeleaf/goodsIpgo/goodsList1";
	}
	@GetMapping("goodsIpgoDetail")
	public String detailView(@ModelAttribute(value = "ipgoNum") String ipgoNum
			,@ModelAttribute(value = "goodsNum") String goodsNum) {
		return "thymeleaf/goodsIpgo/ipgoDetail";
	}
	@PostMapping("goodsIpgoDetail")
	@ResponseBody
	public GoodsIpgoGoodsNameDTO ipgoDetail(Model model , String ipgoNum,  String goodsNum) {
		GoodsIpgoGoodsNameDTO dto = ipgoDetailService.execute(model, ipgoNum, goodsNum);
		return dto;
	}
	@GetMapping("goodsIpgoUpdate")
	public String ipgoUpdate(Model model, String ipgoNum, String goodsNum, IpgoCommand ipgoCommand) {
		ipgoDetailService.execute(model, ipgoNum, goodsNum);
		return "thymeleaf/goodsIpgo/ipgoUpdate";
	}
	@PostMapping("goodsIpgoUpdate")
	   public String goodsIpgoModify(IpgoCommand ipgoCommand) {
	      ipgoUpdateService.execute(ipgoCommand);
	      return "redirect:goodsIpgoDetail?ipgoNum="+ipgoCommand.getIpgoNum()
	                                    +"&goodsNum="+ipgoCommand.getGoodsNum();
	   }
	
	@GetMapping("goodsIpgoDelete")
	public String ipgoDelete(String nums) {
		ipgoDeleteService.execute(nums);
		return "redirect:goodsIpgoList";
	}
	
}
