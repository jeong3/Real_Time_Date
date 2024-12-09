package springBootMVCAlbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.PurchaseCommand;
import springBootMVCAlbum.domain.OrderListDTO;
import springBootMVCAlbum.mapper.PurchaseSelectMapper;
import springBootMVCAlbum.service.purchase.GoodsOrderRegistService;
import springBootMVCAlbum.service.purchase.GoodsOrderService;
import springBootMVCAlbum.service.purchase.IniPayReqService;
import springBootMVCAlbum.service.purchase.MyPurchaseSevice;
import springBootMVCAlbum.service.purchase.PurchaseListSevice;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	@Autowired
	GoodsOrderService goodsOrderService;
	@Autowired
	GoodsOrderRegistService goodsOrderRegistService;
	@Autowired
	IniPayReqService iniPayReqService;
	@Autowired
	MyPurchaseSevice myPurchaseSevice;
	@Autowired
	PurchaseListSevice purchaseListSevice;
	@Autowired
	PurchaseSelectMapper purchaseMapper;
	
	@RequestMapping("purchaseRegist")
	public String purchaseRegist(@RequestBody List<String> cartNums, Model model) {
		goodsOrderService.execute(cartNums, model);
	    return "thymeleaf/purchase/purchaseRegist";
	}
	@PostMapping("goodsOrder")
	public String goodsOrder(@RequestBody PurchaseCommand purchaseCommand, HttpSession session) {
		String purchaseNum = goodsOrderRegistService.execute(purchaseCommand, session);
		return "redirect:paymentOk?purchaseNum="+purchaseNum;
	}
	@RequestMapping("paymentOk")
	public String paymentOk(@RequestParam("purchaseNum") String purchaseNum, Model model, HttpSession session) {
		try {
			iniPayReqService.execute(purchaseNum, model, session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "thymeleaf/purchase/payment";
	}
	@GetMapping("myPurchase")
	public String myPurchase(HttpSession session, Model model) {
		myPurchaseSevice.execute(session, model);
		return "thymeleaf/purchase/myPurchase";
	}
	@GetMapping("purchaseList")
	public String purchaseList(Model model) {
		purchaseListSevice.execute(model);
		return "thymeleaf/purchase/purchaseList";
	}
	@GetMapping("deliveryRegist")
	public String deliveryRegist(@RequestParam("purchaseNum") String purchaseNum, Model model) {
		System.out.println(purchaseNum);
		List<OrderListDTO> list = purchaseMapper.purchaseSelectOne(purchaseNum);
		model.addAttribute("list", list);
		return "thymeleaf/delivery/deliveryRegist";
	}
	@GetMapping("purchaseDetail")
	public String purchaseDetail(@RequestParam("purchaseNum") String purchaseNum, Model model , HttpSession session) {
		System.out.println(purchaseNum);
		List<OrderListDTO> list = purchaseMapper.purchaseSelectOne(purchaseNum);
		
		model.addAttribute("list", list);

		return "thymeleaf/purchase/myPurchaseDetail";
	}
	
	
}
