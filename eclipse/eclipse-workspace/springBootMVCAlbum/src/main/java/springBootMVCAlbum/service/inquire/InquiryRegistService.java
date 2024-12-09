package springBootMVCAlbum.service.inquire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.domain.InquireDTO;
import springBootMVCAlbum.mapper.InquireMapper;

@Service
public class InquiryRegistService {
	@Autowired
	InquireMapper inquireMapper;
	public void execute(InquireDTO dto, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		dto.setMemberNum(auth.getUserNum()); 
		System.out.println(dto);
		inquireMapper.inquireRegist(dto);
		
	}

}
