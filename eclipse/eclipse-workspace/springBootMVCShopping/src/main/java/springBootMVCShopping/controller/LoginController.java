package springBootMVCShopping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springBootMVCShopping.command.LoginCommand;
import springBootMVCShopping.service.IdCheckService;
import springBootMVCShopping.service.login.AutoLoginService;
import springBootMVCShopping.service.login.UserLoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	IdCheckService idCheckService;
	@Autowired
	UserLoginService userLoginService;
	@Autowired
	AutoLoginService autoLoginService;
	
	@PostMapping("userIdCheck")
	//@ResponseBody는 spring방식으로 html파일 , jsp파일의 경로가 아닌 값이나 오브젝트를 리턴하기 위해서 필요하다
	public @ResponseBody Integer userIdCheck(String userId) {
		System.out.println("userId : " + userId);
		Integer i = idCheckService.execute(userId);
		System.out.println(i+"컨트롤러");
		return i;
	}
	@RequestMapping("login")
	public String login(@Validated LoginCommand loginCommand, BindingResult result ,HttpSession session, HttpServletResponse response) {
		userLoginService.execute(loginCommand, result, session, response);
		if(result.hasErrors()) {
			return "thymeleaf/index";
		}
		return "redirect:/";
	}
	@GetMapping("logout")
	public String logout(HttpSession session, HttpServletResponse response, Model model, HttpServletRequest request, LoginCommand loginCommand) {	
		Cookie cookie = new Cookie("autoLogin", "");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		session.invalidate(); // 세션종료
		return "redirect:/";
	}
	@GetMapping("item.login")
	public String item() {
		
		return "thymeleaf/login";
	}
	@PostMapping("item.login")
	public void item(LoginCommand loginCommand,BindingResult result, HttpSession session, HttpServletResponse response ) {
		userLoginService.execute(loginCommand, result, session, response);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = "<script language='javascript'>"
				+ "opener.location.reload();"
				+ "window.self.close();"
				+ "</script>";
		out.print(str);
		out.close();
	}
	
}
