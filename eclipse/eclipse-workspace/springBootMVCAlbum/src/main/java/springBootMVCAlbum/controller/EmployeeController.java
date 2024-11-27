package springBootMVCAlbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springBootMVCAlbum.command.EmpCommand;
import springBootMVCAlbum.service.AutoNumService;
import springBootMVCAlbum.service.emp.EmpDeleteService;
import springBootMVCAlbum.service.emp.EmpDetailService;
import springBootMVCAlbum.service.emp.EmpListService;
import springBootMVCAlbum.service.emp.EmpPwUpdateService;
import springBootMVCAlbum.service.emp.EmpRegistService;
import springBootMVCAlbum.service.emp.EmpUpdateService;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	EmpRegistService empRegistService;
	@Autowired
	EmpListService empListService;
	@Autowired
	EmpDetailService empDetailService;
	@Autowired
	EmpUpdateService empUpdateService;
	@Autowired
	EmpPwUpdateService empPwUpdateService;
	@Autowired
	EmpDeleteService empDeleteService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("empList")
	public String empList(Model model) {
		empListService.execute(model);
		return "thymeleaf/emp/empList";
	}
	@GetMapping("empRegist")
	public String empRegist(String sep, String columnName, Integer len, String tableName, Model model,
			EmpCommand empCommand) {
		String empNum = autoNumService.execute("emp_", "emp_num", 5, "employees");
		empCommand.setEmpNum(empNum);
		model.addAttribute("empCommand", empCommand);
		return "thymeleaf/emp/empRegist";
	}

	@PostMapping("empRegist")
	public String empRegist(@Validated EmpCommand empCommand, BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/emp/empRegist";
		}
		if (!empCommand.isEmpPwEqualEmpPwCon()) {
			// model.addAttribute("errPw", "비밀번호가 일치하지 않습니다.");
			result.rejectValue("empPwCon", "empCommand.empPwCon", "비밀번호가 일치하지 않습니다.");
			return "thymeleaf/emp/empRegist";
		}

		empRegistService.execute(empCommand);
		return "redirect:/";
	}

	@GetMapping("empDetail")
	public String empDetail(String empNum, Model model) {
		empDetailService.execute(empNum, model);
		return "thymeleaf/emp/empDetail";
	}

	@GetMapping("empUpdate")
	public String empUpdate(String empNum, Model model) {
		empDetailService.execute(empNum, model);
		return "thymeleaf/emp/empUpdate";
	}

	@PostMapping("empUpdate")
	public String empUpdate(@Validated EmpCommand empCommand, BindingResult result, Model model,
			String empPwCon) {
		model.addAttribute("empPwCheck", empPwCon);
		if (result.hasErrors()) {
			return "thymeleaf/emp/empUpdate";
		}
		if (!passwordEncoder.matches(empCommand.getEmpPw(), empPwCon)) {
			result.rejectValue("empPw", "empCommand.empPw", "비밀번호가 일치하지 않습니다.");
			return "thymeleaf/emp/empUpdate";
		}
		empUpdateService.execute(empCommand);
		return "redirect:/?empNum=" + empCommand.getEmpNum();
	}

	@GetMapping("empPwUpdate")
	public String empPwUpdate(String empNum, Model model) {
		empDetailService.execute(empNum, model);
		return "thymeleaf/emp/empPwUpdate";
	}

	@RequestMapping("empPwUpdate")
	@ResponseBody
	public String empPwUpdate(String empPw, String empPwcon, String updatePw, String empNum) {
		String result = empPwUpdateService.execute(empPw, empPwcon, updatePw, empNum);
		return result;
	}

	@RequestMapping("empDelete")
	@ResponseBody
	public String empDelete(String empNum) {
		try {
			empDeleteService.execute(empNum);
			return "success";
		} catch (Exception e) {
			return "error";
		}

	}
}
