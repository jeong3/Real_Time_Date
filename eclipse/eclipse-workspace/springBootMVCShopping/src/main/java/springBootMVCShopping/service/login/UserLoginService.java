package springBootMVCShopping.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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
	public void execute(LoginCommand loginCommand, BindingResult result, HttpSession session) {
		AuthInfoDTO auth = loginMapper.LoginSelectOne(loginCommand.getUserId());
		if(auth != null) {
			System.out.println("아이디가 존재합니다.");
			
			//본문(Command)의 비밀번호, 암호문(DB)의의 비밀번호
			if(passwordEncoder.matches(loginCommand.getUserPw(), auth.getUserPw())) { 
				System.out.println("비밀번호가 일치합니다.");
				session.setAttribute("auth", auth);
			} else {
				if(loginCommand.getUserPw() != null) {
				result.rejectValue("userPw", "loginCommand.userPw", "비밀번호가 일치하지않습니다.");
				System.out.println("비밀번호가 일치하지않습니다.");
				}
			}
		} else {
			if(loginCommand.getUserId() != null) {
			result.rejectValue("userId", "loginCommand.userId", "아이디가 일치하지않습니다.");
			System.out.println("아이디가 존재하지 않습니다.");
			}
		}
	}

}
