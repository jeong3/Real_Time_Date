package springBootMVCAlbum.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCAlbum.mapper.LoginMapper;

@Service
public class IdCheckService {
	@Autowired
	LoginMapper loginMapper;
	public Integer execute(String userId) {
		System.out.println(loginMapper.idCheckSelectOne(userId)+"서비스");
		return loginMapper.idCheckSelectOne(userId);
		
	}
	
}
