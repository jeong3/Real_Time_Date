package springBootMVCShopping.service.ipgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.mapper.AutoNumMapper;
import springBootMVCShopping.mapper.IpgoMapper;

@Service
public class IpgoDeleteService {
	@Autowired
	AutoNumMapper autoNumMapper;
	public void execute(String[] ipgoNums) {
		autoNumMapper.numsDelete(ipgoNums, "goods_ipgo", "ipgo_num");
	}
	
}
