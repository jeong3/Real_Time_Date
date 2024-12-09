package springBootMVCAlbum.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.domain.InquireDTO;
import springBootMVCAlbum.service.inquire.InquiryAnswerRegistService;
import springBootMVCAlbum.service.inquire.InquiryListService;
import springBootMVCAlbum.service.inquire.InquiryRegistService;

@Controller
@RequestMapping("inquire")
public class InquireController {
	@Autowired
	InquiryRegistService inquiryRegistService;
	@Autowired
	InquiryListService inquiryListService;
	@Autowired
	InquiryAnswerRegistService inquiryAnswerRegistService;
	@GetMapping("inquireList")
	public String inquiryList(Model model) {
		inquiryListService.execute(model);
		return "thymeleaf/inquire/inquireList";
	}
	@GetMapping("InquireListEmp")
	public String InquireListEmp(Model model) {
		inquiryListService.execute(model);
		return "thymeleaf/inquire/InquireListEmp";
	}
	@GetMapping("inquireRegist")
	public String inquiryRegist() {
		return "thymeleaf/inquire/inquireRegist";
	}
	@PostMapping("inquireRegist")
	public String inquiryRegist(@RequestBody InquireDTO dto, HttpSession session) {
		inquiryRegistService.execute(dto, session);
		return "redirect:inquireList";
	}
	@RequestMapping("inquireAnswer")
	public String inquireAnswer(@RequestBody Map<String, String> map, HttpSession session) {
		
		System.out.println(map.get("inquireNum")+map.get("inquireAnswer")+"답");
		inquiryAnswerRegistService.execute(map.get("inquireNum"),map.get("inquireAnswer"), session);
		return "redirect:InquireListEmp";
	}
}
