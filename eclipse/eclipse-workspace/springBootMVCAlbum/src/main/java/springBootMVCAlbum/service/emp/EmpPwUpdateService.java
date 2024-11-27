package springBootMVCAlbum.service.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springBootMVCAlbum.mapper.EmpMapper;

@Service
public class EmpPwUpdateService {
	@Autowired
	EmpMapper empMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String execute(String empPw, String empPwcon, String updatePw, String empNum) {
		if (passwordEncoder.matches(empPw, empPwcon)) {
			updatePw = passwordEncoder.encode(updatePw);
			empMapper.empPwUpdate(updatePw, empNum);
			return "success";
		} else {
		    System.out.println("비밀번호가 일치하지 않습니다.");
		}
		return"";
		
	}

}
