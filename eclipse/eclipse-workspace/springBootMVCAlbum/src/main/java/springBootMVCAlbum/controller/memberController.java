package springBootMVCAlbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springBootMVCAlbum.command.MemberCommand;
import springBootMVCAlbum.service.AutoNumService;
import springBootMVCAlbum.service.member.MemberDeleteService;
import springBootMVCAlbum.service.member.MemberDetailService;
import springBootMVCAlbum.service.member.MemberListService;
import springBootMVCAlbum.service.member.MemberPwUpdateService;
import springBootMVCAlbum.service.member.MemberRegistService;
import springBootMVCAlbum.service.member.MemberUpdateService;

@Controller
@RequestMapping("member")
public class memberController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	MemberRegistService memberRegistService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@Autowired
	MemberPwUpdateService memberPwUpdateService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("memberList")
	public String memberList(Model model) {
		memberListService.execute(model);
		return "thymeleaf/member/memberList";
	}

	@GetMapping("memberRegist")
	public String memberRegist(String sep, String columnName, Integer len, String tableName, Model model,
			MemberCommand memberCommand) {
		String memberNum = autoNumService.execute("mem_", "member_num", 5, "members");
		memberCommand.setMemberNum(memberNum);
		model.addAttribute("memberCommand", memberCommand);
		return "thymeleaf/member/memberRegist";
	}

	@PostMapping("memberRegist")
	public String memberRegist(@Validated MemberCommand memberCommand, BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/member/memberRegist";
		}
		if (!memberCommand.isMemberPwEqualMemberPwCon()) {
			// model.addAttribute("errPw", "비밀번호가 일치하지 않습니다.");
			result.rejectValue("memberPwcon", "memberCommand.memberPwcon", "비밀번호가 일치하지 않습니다.");
			return "thymeleaf/member/memberRegist";
		}

		memberRegistService.execute(memberCommand);
		return "redirect:/";
	}

	@GetMapping("memberDetail")
	public String memberDetail(String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberDetail";
	}

	@GetMapping("memberUpdate")
	public String memberUpdate(String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberUpdate";
	}

	@PostMapping("memberUpdate")
	public String memberUpdate(@Validated MemberCommand memberCommand, BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/member/memberUpdate";
		}
		if (passwordEncoder.matches(memberCommand.getMemberPw(), memberCommand.getMemberPwcon())) {
			// model.addAttribute("errPw", "비밀번호가 일치하지 않습니다.");
			result.rejectValue("memberPwcon", "memberCommand.memberPwcon", "비밀번호가 일치하지 않습니다.");
			return "thymeleaf/member/memberUpdate";
			
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
		memberUpdateService.execute(memberCommand);
		return "redirect:/?memberNum=" + memberCommand.getMemberNum();
	}

	@GetMapping("memberPwUpdate")
	public String memberPwUpdate(String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberPwUpdate";
	}

	@RequestMapping("memberPwUpdate")
	@ResponseBody
	public String memberPwUpdate(String memberPw, String memberPwcon, String updatePw, String memberNum) {
		String result = memberPwUpdateService.execute(memberPw, memberPwcon, updatePw, memberNum);
		return result;
	}

	@RequestMapping("memberDelete")
	@ResponseBody
	public String memberDelete(String memberNum) {
		try {
			memberDeleteService.execute(memberNum);
			return "success";
		} catch (Exception e) {
			return "error";
		}

	}
}
