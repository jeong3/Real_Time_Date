package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.service.purchase.OrderListService;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	@Autowired
	OrderListService orderListService;
	
	@GetMapping("orderList")
	public String orderList(HttpSession session, Model model) {
		orderListService.execute(session, model);
		return "thymeleaf/purchase/orderList";
	}
	@GetMapping("purchaseList")
	public String purchaseList(HttpSession session, Model model) {
		orderListService.execute(session, model);
		return "thymeleaf/purchase/purchaseList";
	}
}
