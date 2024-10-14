package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCShopping.command.MemberCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.member.MemberWriteService;

@Controller
@RequestMapping("member") // 공통주소 처리
public class MemberController {
	@Autowired
	MemberWriteService memberWriteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("memberList") // 절대주소
	public String list() {

		return "thymeleaf/member/memberList";
		// return "member/memberList";
	}

	@GetMapping("memberWrite")
	public String write(Model model) {
		String autoNum = autoNumService.execute("mem_", "member_num", 5, "members");
		MemberCommand memberCommand = new MemberCommand();
		memberCommand.setMemberNum(autoNum);
		model.addAttribute("memberCommand", memberCommand);
		return "thymeleaf/member/memberForm";
	}

	@PostMapping("memberRegist")
	public String write(@Validated MemberCommand memberCommand, BindingResult result // 꼭 커맨드 뒤에 적어줘야함
			 /*, Model model*/) {
		if (result.hasErrors()) {
			return "thymeleaf/member/memberForm";
		}
		
		if (!memberCommand.isMemberPwEqualMemberPwCon()) {
			//model.addAttribute("errPw", "비밀번호가 일치하지 않습니다.");
			result.rejectValue("memberPwcon", "memberCommand.memberPwcon", "비밀번호가 일치하지 않습니다.");
			return "thymeleaf/member/memberForm";
		}
		memberWriteService.execute(memberCommand);
		return "redirect:memberList";

	}

}
