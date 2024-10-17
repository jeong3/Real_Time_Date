package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootMVCShopping.command.MemberCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.member.MemberDetailService;
import springBootMVCShopping.service.member.MemberListService;
import springBootMVCShopping.service.member.MemberUpdateService;
import springBootMVCShopping.service.member.MemberWriteService;
import springBootMVCShopping.service.member.MembersDeleteService;

@Controller
@RequestMapping("member") // 공통주소 처리
public class MemberController {
	@Autowired
	MemberWriteService memberWriteService;
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MembersDeleteService membersDeleteService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@GetMapping("memberList") // 절대주소
	public String list(@RequestParam(value="page", required=false, defaultValue="1") Integer page,
			@RequestParam(value="searchWord", required=false) String searchWord, Model model) {
		memberListService.execute(page,searchWord,model);
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
	
	@RequestMapping(value = "membersDelete")
	public String Delete(@RequestParam("nums") String memberNums []) { 
		// nums의 값을 매개변수 memberNums []로 받음 name과 같은 값으로도 받을 수 있다.
		membersDeleteService.execute(memberNums);
		return "redirect:memberList";
	}
	//PathVariable
	@GetMapping("memberDetail/{memberNum}")
	public String memberDetail(@PathVariable("memberNum") String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberInfo";
	}
	@GetMapping("memberUpdate") 
	// memberDetail에서 PathVariable을 사용했기 때문에 주소가 
	///member/memberDetail/memberUpdate가 되므로 수정으로 가는 a태그 앞에 ../를 붙혀 상위폴더로 가야한다
	public String memberUpdate(String memberNum,Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberModify";
	}
	@PostMapping("memberUpdate")
	public String memberUpdate(@Validated MemberCommand memberCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberModify";
		}
		memberUpdateService.execute(memberCommand);
		return "redirect:memberDetail/"+memberCommand.getMemberNum(); //memberDetail에서 PathVariable방식이기 때문에 /+멤버넘값
	}
	
	@GetMapping("memberDelete/{memberNum}")
	public String memberDelete(@PathVariable("memberNum") String [] memberNums) {
		membersDeleteService.execute(memberNums);
		return "redirect:../memberList";
		
	}
}










