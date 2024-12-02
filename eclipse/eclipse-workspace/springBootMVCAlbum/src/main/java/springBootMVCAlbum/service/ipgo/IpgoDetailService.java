package springBootMVCAlbum.service.ipgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCAlbum.domain.IpgoDTO;
import springBootMVCAlbum.mapper.IpgoMapper;

@Service
public class IpgoDetailService {
	@Autowired
	IpgoMapper ipgoMapper;

	public void execute(String ipgoNum,Model model) {
		
		IpgoDTO dto = ipgoMapper.ipgoSelectOne(ipgoNum);
		model.addAttribute("dto", dto);
		
	}
	
}
