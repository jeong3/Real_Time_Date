package springBootMVCShopping.service.ipgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.IpgoDTO;
import springBootMVCShopping.mapper.IpgoMapper;

@Service
public class IpgoDetailService {
	@Autowired
	IpgoMapper ipgoMapper;

	public void execute(Model model, String ipgoNum) {
		IpgoDTO dto = ipgoMapper.ipgoSelectOne(ipgoNum);
		model.addAttribute("ipgoCommand", dto);
	}
	
}
