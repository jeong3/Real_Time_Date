package springBootMVCShopping.service.ipgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.mapper.AutoNumMapper;
import springBootMVCShopping.mapper.IpgoMapper;

@Service
public class IpgoDeleteService {
	@Autowired
	IpgoMapper ipgoMapper;
	public void execute(String nums) {
		ipgoMapper.ipgoDelete(nums);
	}
	
}
