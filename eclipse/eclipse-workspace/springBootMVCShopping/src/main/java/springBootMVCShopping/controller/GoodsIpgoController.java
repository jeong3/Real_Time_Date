package springBootMVCShopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("goodsIpgo")
public class GoodsIpgoController {
	@GetMapping("goodsIpgoList")
	public String ipgoList() {
		return "thymeleaf/goodsIpgo/goodsIpgoList";
	}
}
