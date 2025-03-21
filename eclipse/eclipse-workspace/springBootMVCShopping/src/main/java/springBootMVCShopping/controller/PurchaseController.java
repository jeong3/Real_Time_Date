package springBootMVCShopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCShopping.command.PurchaseCommand;
import springBootMVCShopping.repository.PurchaseRepository;
import springBootMVCShopping.service.purchase.GoodsBuyService;
import springBootMVCShopping.service.purchase.GoodsOrderService;
import springBootMVCShopping.service.purchase.IniPayReqService;
import springBootMVCShopping.service.purchase.OrderListService;
import springBootMVCShopping.service.purchase.PurchaseListService;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	@Autowired
	OrderListService orderListService;
	@Autowired
	PurchaseListService purchaseListService;
	@Autowired
	GoodsBuyService goodsBuyService;
	@Autowired
	GoodsOrderService goodsOrderService;
	@Autowired
	IniPayReqService iniPayReqService;
	@Autowired
	PurchaseRepository purchaseRepository;
	
	
	@RequestMapping("goodsBuy")
	public String goodsBuy(String nums[], HttpSession session, Model model) {
		goodsBuyService.execute(nums, session, model);
		return "thymeleaf/purchase/goodsOrder";
	}
	@PostMapping("goodsOrder")
	public String goodsOrder(PurchaseCommand purchaseCommand, HttpSession session, Model model) {
		String purchaseNum = goodsOrderService.execute(purchaseCommand, session, model);
		return "redirect:paymentOk?purchaseNum="+purchaseNum;
	}
	@GetMapping("paymentOk")
	public String paymentOk(String purchaseNum, Model model) {
		try {
			iniPayReqService.execute(purchaseNum, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "thymeleaf/purchase/payment";
	}
	
	@GetMapping("paymentDel")
	public String paymentDel(String purchaseNum) {
		purchaseRepository.paymentDel(purchaseNum);
		return "redirect:orderList";
	}
	@GetMapping("purchaseOk")
	public String purchaseOk (String purchaseNum) {
		purchaseRepository.paymentStatusUpdate(purchaseNum);
		return "redirect:orderList";
	}
	
	@GetMapping("orderList")
	public String orderList(HttpSession session, Model model) {
		orderListService.execute(session, model, null);
		return "thymeleaf/purchase/orderList";
	}
	@GetMapping("purchaseList")
	public String purchaseList(HttpSession session, Model model) {
		orderListService.execute(session, model, null);
		return "thymeleaf/purchase/purchaseList";
	}
	
}
