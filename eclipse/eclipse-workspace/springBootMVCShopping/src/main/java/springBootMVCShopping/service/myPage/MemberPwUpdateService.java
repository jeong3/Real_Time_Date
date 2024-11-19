package springBootMVCShopping.service.myPage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.MemberInfoMapper;

@Service
public class MemberPwUpdateService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberInfoMapper infoMapper;
	public void execute(String oldPw, String newPw, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		if(passwordEncoder.matches(oldPw, auth.getUserPw())) {
			newPw = passwordEncoder.encode(newPw);
			infoMapper.memberPwUpdate(newPw, auth.getUserId());	
		}
	}

}
