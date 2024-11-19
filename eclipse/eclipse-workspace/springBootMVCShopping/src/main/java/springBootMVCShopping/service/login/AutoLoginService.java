package springBootMVCShopping.service.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.command.LoginCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.LoginMapper;

@Service
public class AutoLoginService {
	@Autowired
	LoginMapper loginMapper;
	public void execute(String value, HttpServletRequest request, Model model, LoginCommand loginCommand) {
		AuthInfoDTO auth = loginMapper.LoginSelectOne(value);
		HttpSession session = request.getSession();
		loginCommand.setUserId(auth.getUserId());
		loginCommand.setUserId(auth.getUserPw());
		model.addAttribute("loginCommand", loginCommand);
		
	}

}
