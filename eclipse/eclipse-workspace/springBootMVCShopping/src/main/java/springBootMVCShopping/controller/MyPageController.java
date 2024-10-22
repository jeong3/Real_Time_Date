package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.MemberCommand;
import springBootMVCShopping.service.myPage.MemberDropService;
import springBootMVCShopping.service.myPage.MemberMyInfoService;
import springBootMVCShopping.service.myPage.MemberMyUpdateService;
import springBootMVCShopping.service.myPage.MemberPwUpdateService;

@Controller
@RequestMapping("myPage")
public class MyPageController {
	@Autowired
	MemberMyInfoService memberMyInfoService;
	@Autowired
	MemberMyUpdateService memberMyUpdateService;
	@Autowired
	MemberPwUpdateService memberPwUpdateService;
	@Autowired
	MemberDropService memberDropService;
	
	@GetMapping("memberMyPage")
	public String memMyPage(HttpSession session, Model model) {
		memberMyInfoService.execute(session, model);
		return "thymeleaf/myPage/memberMyPage";
	}
	@GetMapping("memberUpdate")
	public String memUpdate(HttpSession session, Model model) {
		memberMyInfoService.execute(session, model);
		return "thymeleaf/myPage/myModify";
	}
	@PostMapping("memberModify")
	public String memberModify(MemberCommand memberCommand, HttpSession session) {
		memberMyUpdateService.execute(memberCommand,session);
		return "redirect:memberMyPage";
	}
	@GetMapping("memberPwModify")
	public String memPwModify() {
		return "thymeleaf/myPage/myNewPw";
	}
	@PostMapping("memberPwPro")
	public String memberPwPro(String oldPw, String newPw, HttpSession session) {
		memberPwUpdateService.execute(oldPw, newPw, session);
		return "redirect:memberMyPage";
	}
	@GetMapping("memberDrop")
	public String memberDrop() {
		
		return "thymeleaf/myPage/memberDrop";
	}
	@PostMapping("memberDrop")
	public String memberDrop(String memberPw, HttpSession session) {
		memberDropService.execute(memberPw, session);
		return "redirect:/login/logout";
		
	}
	
}
