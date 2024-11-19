package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCShopping.command.UserCommand;
import springBootMVCShopping.service.memberJoin.UserWriteService;


@Controller
@RequestMapping("register")
public class MemberJoinController {
	@Autowired
	UserWriteService userWriteService;
	
	
	@RequestMapping("userAgree")
	public String agree() {
		return "thymeleaf/memberJoin/agree";
	}
	@ModelAttribute // 모든 메서드에 UserCommand를 받아줌
	public UserCommand userCommand() {
		return new UserCommand();
	}
	@GetMapping("userWrite")
	public String write(UserCommand userCommand) {
		return "thymeleaf/memberJoin/userForm";
	}
	//@Validated 유효성검사
	@PostMapping("userWrite")
	public String write(@Validated UserCommand userCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/memberJoin/userForm";
		}
		if (!userCommand.isUserPwEqualsUserPwCon()) {
			//model.addAttribute("errPw", "비밀번호가 일치하지 않습니다.");
			result.rejectValue("userPwCon", "userCommand.userPwCon", "비밀번호가 일치하지 않습니다.");
			return "thymeleaf/memberJoin/userForm";
		}
		
		userWriteService.execute(userCommand);
		return "thymeleaf/memberJoin/welcome";
	}
}
