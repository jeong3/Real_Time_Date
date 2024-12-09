package springBootMVCAlbum.service.inquire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCAlbum.domain.InquireDTO;
import springBootMVCAlbum.mapper.InquireMapper;

@Service
public class InquiryListService {
	@Autowired
	InquireMapper inquireMapper;
	public void execute(Model model) {
		List<InquireDTO> list = inquireMapper.inquireSelect();
		model.addAttribute("list", list);
		
	}

}
