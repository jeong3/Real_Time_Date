package springBootMVCAlbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.LoginCommand;
import springBootMVCAlbum.service.user.IdCheckService;
import springBootMVCAlbum.service.user.UserLoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	UserLoginService userLoginService;
	@Autowired
	IdCheckService idCheckService;
	
	
	@RequestMapping("login")
	public String login(@ModelAttribute("loginCommand") LoginCommand loginCommand, HttpServletResponse response, HttpSession session, Model model) {
		userLoginService.execute(loginCommand, session, response);
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
	@PostMapping("userIdCheck")
	//@ResponseBody는 spring방식으로 html파일 , jsp파일의 경로가 아닌 값이나 오브젝트를 리턴하기 위해서 필요하다
	public @ResponseBody Integer userIdCheck(String userId) {
		System.out.println("userId : " + userId);
		Integer i = idCheckService.execute(userId);
		System.out.println(i+"컨트롤러");
		return i;
	}
}
