package springBootMVCAlbum.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.service.emp.EmpDetailService;
import springBootMVCAlbum.service.member.MemberDetailService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	EmpDetailService empDetailService;
	
	@GetMapping("userDetail")
	public String userDetail(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		System.out.println(auth.getGrade());
		System.out.println(auth.getUserNum());
		if(auth.getGrade() == "emp") {
			empDetailService.execute(auth.getUserNum(), model);
			return "thymeleaf/emp/empDetail";
		}else if(auth.getGrade() == "mem") {
			memberDetailService.execute(auth.getUserNum(), model);
			return "thymeleaf/member/memberDetail";
		}else {
			return "redirect:/";
		}
		
		
	}
}
