package springBootMVCShopping.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.LoginCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.LoginMapper;

@Service
public class UserLoginService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(LoginCommand loginCommand, BindingResult result, HttpSession session, HttpServletResponse response) {
		AuthInfoDTO auth = loginMapper.LoginSelectOne(loginCommand.getUserId());
		if(auth != null) {
			System.out.println("아이디가 존재합니다.");
			
			//본문(Command)의 비밀번호, 암호문(DB)의의 비밀번호
			if(passwordEncoder.matches(loginCommand.getUserPw(), auth.getUserPw())) { 
				System.out.println("비밀번호가 일치합니다.");
				session.setAttribute("auth", auth);
				
				if(loginCommand.isIdStore() == true) {
					System.out.println(loginCommand.isIdStore()+"dfsfsdf");
					Cookie cookie = new Cookie("userId", auth.getUserId());
					cookie.setMaxAge(60*60*24*30);
					cookie.setPath("/");
					response.addCookie(cookie);
					System.out.println(cookie.getName()+"아이디저장");
				} else {
					Cookie cookie = new Cookie("userId", "");
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			
				if(loginCommand.isAutoLogin() == true) {
					System.out.println(loginCommand.isAutoLogin()+"dfsfsdf");
					Cookie cookie = new Cookie("autoLogin", auth.getUserId());
					cookie.setMaxAge(60*60*24*30);
					cookie.setPath("/");
					response.addCookie(cookie);
					System.out.println(cookie+"자동로그인");
				} 
				
				
				
			} else {
				if(loginCommand.getUserPw() != null) {
				result.rejectValue("userPw", "loginCommand.userPw", "비밀번호가 일치하지않습니다.");
				System.out.println("비밀번호가 일치하지않습니다.");
				}
			}
		} else {
			if(loginCommand.getUserId() != null) {
			result.rejectValue("userId", "loginCommand.userId", "이메일인증이 안됐거나 아이디가 존재하지 않습니다.");
			System.out.println("아이디가 존재하지 않습니다.");
			}
		}
		
		
		
	}

}
