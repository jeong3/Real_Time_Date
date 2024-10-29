package springBootMVCShopping.service.ipgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.IpgoDTO;
import springBootMVCShopping.domain.StartEndPageDTO;
import springBootMVCShopping.mapper.IpgoMapper;
import springBootMVCShopping.service.StartEndPageService;

@Service
public class IpgoListService {
	@Autowired
	IpgoMapper ipgoMapper;
	@Autowired
	StartEndPageService startEndPageService;
	
	public void execute(Integer page, String searchWord, Model model) {
		Integer limit = 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, searchWord, limit);
		List<IpgoDTO> list = ipgoMapper.ipgoSelectAll(sepDTO);
		Integer count = ipgoMapper.ipgoCount();
		startEndPageService.execute(page, limit, count, searchWord, list, model);
		
	}

}
