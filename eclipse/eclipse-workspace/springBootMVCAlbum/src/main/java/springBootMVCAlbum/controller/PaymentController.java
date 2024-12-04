package springBootMVCAlbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import springBootMVCAlbum.service.purchase.INIstdpayPcReturn;

@Controller
@RequestMapping("payment")
public class PaymentController {
	@Autowired
	INIstdpayPcReturn iNIstdpayPcReturn;
	
	@RequestMapping("INIstdpay_pc_return")
	public String payReturn(HttpServletRequest request, Model model) {
		iNIstdpayPcReturn.execute(request, model);
		
		return "thymeleaf/purchase/buyfinished";
	}
	@RequestMapping("close")
	public String close() {
		return "thymeleaf/purchase/close";
	}
}
