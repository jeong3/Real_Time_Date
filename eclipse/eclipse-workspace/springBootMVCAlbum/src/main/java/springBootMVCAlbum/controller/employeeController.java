package springBootMVCAlbum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("emp")
public class employeeController {
	@GetMapping("empList")
	public String empList() {
		return "thymeleaf/emp/empList";
	}
}
