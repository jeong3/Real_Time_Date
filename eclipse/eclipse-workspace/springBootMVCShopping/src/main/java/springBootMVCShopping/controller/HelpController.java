package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCShopping.command.HelpCommand;
import springBootMVCShopping.service.help.FindIdService;
import springBootMVCShopping.service.help.FindPwService;

@Controller
@RequestMapping("help")
public class HelpController {
	@Autowired
	FindIdService findIdService;
	@Autowired
	FindPwService findPwService;
	@GetMapping("findId")
	public String findId() {
		return "thymeleaf/help/findId";
	}
	@PostMapping("findId")
	public String findId(HelpCommand helpCommand, Model model) {
		findIdService.execute(helpCommand, model);
		return "thymeleaf/help/findIdOk";
	}
	@GetMapping("findPassword")
	public String findPassword() {
		return "thymeleaf/help/findPw";
	}
	@PostMapping("findPassword")
	public String findPassword(HelpCommand helpCommand, Model model) {
		findPwService.execute(helpCommand, model);
		return "thymeleaf/help/findPwOk";
	}
}
