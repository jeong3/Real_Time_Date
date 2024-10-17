package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springBootMVCShopping.service.IdCheckService;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	IdCheckService idCheckService;
	
	@PostMapping("userIdCheck")
	//@ResponseBody는 spring방식으로 html파일 , jsp파일의 경로가 아닌 값이나 오브젝트를 리턴하기 위해서 필요하다
	public @ResponseBody Integer userIdCheck(String userId) {
		System.out.println("userId : " + userId);
		Integer i = idCheckService.execute(userId);
		System.out.println(i+"컨트롤러");
		return i;
	}
}
