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

import springBootMVCShopping.command.EmployeeCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.Employee.EmployeeDeleteService;
import springBootMVCShopping.service.Employee.EmployeeDetailService;
import springBootMVCShopping.service.Employee.EmployeeListService;
import springBootMVCShopping.service.Employee.EmployeeUpdateService;
import springBootMVCShopping.service.Employee.EmployeeWriteService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	EmployeeWriteService employeeWriteService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeDetailService employeeDetailService;
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;

	@GetMapping("employeeList")
	public String list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "searchWord", required = false, defaultValue = "") String searchWord, Model model) {
		employeeListService.execute(page,searchWord,model);
		return "thymeleaf/employee/employeeList";
	}

	@GetMapping("employeeWrite")
	public String write(Model model) {
		String autoNum = autoNumService.execute("emp_", "emp_Num", 5, "employees");
		EmployeeCommand employeeCommand = new EmployeeCommand();
		employeeCommand.setEmpNum(autoNum);
		model.addAttribute("employeeCommand", employeeCommand);
		return "thymeleaf/employee/employeeWrite";
	}

	@PostMapping("employeeWrite")
	public String write(@Validated EmployeeCommand employeeCommand, BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/employee/employeeWrite";
		}
		if(!employeeCommand.isEmpPwEqualEmpPwCon()) {
			result.rejectValue("empPwCon", "employeeCommand.empPwCon", "비밀번호가 일치하지 않습니다.");
			return "thymeleaf/employee/employeeWrite";
		}
		employeeWriteService.execute(employeeCommand);
		return "redirect:employeeList";
	}

	// @PathVariable
	@GetMapping("employeeDetail/{empNum}")
	public String detail(@PathVariable("empNum") String empNum, Model model) {
		employeeDetailService.execute(empNum, model);
		return "thymeleaf/employee/employeeDetail";
	}

	@GetMapping("employeeModify")
	public String update(String empNum, Model model) {
		employeeDetailService.execute(empNum, model);
		return "thymeleaf/employee/employeeUpdate";
	}

	@PostMapping("employeeModify")
	public String update(@Validated EmployeeCommand employeeCommand, BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/employee/employeeUpdate";
		}
		employeeUpdateService.execute(employeeCommand);
		return "redirect:employeeDetail/" + employeeCommand.getEmpNum();
	}

	@GetMapping("employeeDelete")
	public String delete(@RequestParam("nums") String [] empNum) {
		employeeDeleteService.execute(empNum);
		return "redirect:employeeList";
	}

}
