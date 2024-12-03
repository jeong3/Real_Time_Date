package springBootMVCAlbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.PurchaseCommand;
import springBootMVCAlbum.service.purchase.GoodsOrderRegistService;
import springBootMVCAlbum.service.purchase.GoodsOrderService;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	@Autowired
	GoodsOrderService goodsOrderService;
	@Autowired
	GoodsOrderRegistService goodsOrderRegistService;
	
	@RequestMapping("purchaseRegist")
	public String purchaseRegist(@RequestBody List<String> cartNums, Model model) {
		goodsOrderService.execute(cartNums, model);
	    return "thymeleaf/purchase/purchaseRegist";
	}
	@PostMapping("goodsOrder")
	public String goodsOrder(PurchaseCommand purchaseCommand, HttpSession session) {
		String purchaseNum = goodsOrderRegistService.execute(purchaseCommand, session);
		return "redirect:paymentOk?purchaseNum="+purchaseNum;
	}
	@GetMapping("paymentOk")
	public String paymentOk(String purchaseNum, Model model) {
		try {
			//iniPayReqService.execute(purchaseNum, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "thymeleaf/purchase/payment";
	}
}
