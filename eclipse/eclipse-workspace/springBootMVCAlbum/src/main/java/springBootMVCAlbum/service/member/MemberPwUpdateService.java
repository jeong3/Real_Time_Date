package springBootMVCAlbum.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springBootMVCAlbum.mapper.MemberMapper;

@Service
public class MemberPwUpdateService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String execute(String memberPw, String memberPwcon, String updatePw, String memberNum) {
		if (passwordEncoder.matches(memberPw, memberPwcon)) {
			updatePw = passwordEncoder.encode(updatePw);
			memberMapper.memberPwUpdate(updatePw, memberNum);
			return "success";
		} else {
		    System.out.println("비밀번호가 일치하지 않습니다.");
		}
		return"";
		
	}

}
