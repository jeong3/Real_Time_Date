package springBootMVCAlbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCAlbum.command.MemberCommand;
import springBootMVCAlbum.service.AutoNumService;
import springBootMVCAlbum.service.member.MemberListService;
import springBootMVCAlbum.service.member.MemberRegistService;

@Controller
@RequestMapping("member")
public class memberController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	MemberRegistService memberRegistService;
	@Autowired
	MemberListService memberListService;
	
	@GetMapping("memberList")
	public String memberList(Model model) {
		memberListService.execute(model);
		return "thymeleaf/member/memberList";
	}
	@GetMapping("memberRegist")
	public String memberRegist(String sep, String columnName, Integer len, String tableName, Model model, MemberCommand memberCommand) {
		String memberNum = autoNumService.execute("mem_","member_num",5,"members");
		memberCommand.setMemberNum(memberNum);
		model.addAttribute("memberCommand", memberCommand);
		return "thymeleaf/member/memberRegist";
	}
	@PostMapping("memberRegist")
	public String memberRegist(@Validated MemberCommand memberCommand , BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/member/memberRegist";
		}
		if (!memberCommand.isMemberPwEqualMemberPwCon()) {
			//model.addAttribute("errPw", "비밀번호가 일치하지 않습니다.");
			result.rejectValue("memberPwcon", "memberCommand.memberPwcon", "비밀번호가 일치하지 않습니다.");
			return "thymeleaf/member/memberForm";
		}
		
		memberRegistService.execute(memberCommand);
		return "redirect:/";
	}
	@GetMapping("memberDetail")
	public String memberDetail() {
		return "thymeleaf/member/memberDetail";
	}
}
