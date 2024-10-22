package springBootMVCShopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.mapper.LoginMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class EmailCheckService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	MemberMapper memberMapper;
	public Integer execute(String userEmail) {
		return loginMapper.EmailCheckSelectOne(userEmail);
	}
	public Integer update(String userEmail) {
		Integer i = loginMapper.EmailCheckSelectOne(userEmail);
		if(i != null) {
			i = memberMapper.memberEmailCheckUpdate(userEmail);
		}
		return i;
	}
	
	
}
