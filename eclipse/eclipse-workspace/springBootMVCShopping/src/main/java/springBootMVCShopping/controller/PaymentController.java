package springBootMVCShopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCShopping.service.purchase.INIstdpayPcReturn;

@Controller
@RequestMapping("payment")
public class PaymentController {
	@Autowired
	INIstdpayPcReturn iNIstdpayPcReturn;
	
	@RequestMapping("INIstdpay_pc_return")
	public String payReturn(HttpServletRequest request) {
		iNIstdpayPcReturn.execute(request);
		return "thymeleaf/purchase/buyfinished";
	}
	@RequestMapping("close")
	public String close() {
		return "thymeleaf/purchase/close";
	}
}
