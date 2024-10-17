package springBootMVCShopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.mapper.LoginMapper;

@Service
public class EmailCheckService {
	@Autowired
	LoginMapper loginMapper;
	public Integer execute(String userEmail) {
		System.out.println(userEmail+"이메일서비스 userEmail보내기");
		System.out.println(loginMapper.EmailCheckSelectOne(userEmail)+"이메일서비스");
		return loginMapper.EmailCheckSelectOne(userEmail);
	}
	
	
}
