package springBootMVCShopping.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springBootMVCShopping.command.EmployeeCommand;
import springBootMVCShopping.command.MemberCommand;
import springBootMVCShopping.service.myPage.EmployeeInfoService;
import springBootMVCShopping.service.myPage.EmployeeModifyService;
import springBootMVCShopping.service.myPage.EmployeePwUpdateService;
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
	@Autowired
	EmployeeInfoService employeeInfoService;
	@Autowired
	EmployeeModifyService employeeModifyService;
	@Autowired
	EmployeePwUpdateService employeePwUpdateService;
	
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
	@GetMapping("empModify")
	public @ResponseBody Map<String, Object> empPage(HttpSession session, Model model) {
		Map<String, Object> map = employeeInfoService.execute(session, model );
		return map;
	}
	@PostMapping("empModify")
	public String empModify(EmployeeCommand employeeCommand, HttpSession session) {
		employeeModifyService.execute(employeeCommand, session);
		return "redirect:employeeMyPage";
	}
	
	@GetMapping("employeeMyPage")
	public String empMyPage() {
		return "thymeleaf/myPage/employeeInfo";
	}
	@PostMapping("empMyPage")
	@ResponseBody
	public ModelAndView empMyPage(HttpSession session,Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		employeeInfoService.execute(session, model);
		return mav;
	}
	
	@PostMapping("empPwPro")
	public String empPwPro(@RequestParam("oldPw") String oldPw
						,String newPw, HttpSession session) {
		employeePwUpdateService.execute(oldPw, newPw, session);
		return "redirect:employeeMyPage";
	}
	
}
