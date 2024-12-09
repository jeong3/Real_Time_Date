package springBootMVCAlbum.service.inquire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.domain.InquireDTO;
import springBootMVCAlbum.mapper.InquireMapper;

@Service
public class InquiryAnswerRegistService {
	@Autowired
	InquireMapper inquireMapper;
	public void execute(String inquireNum, String inquireAnswer, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		InquireDTO dto = new InquireDTO();
		dto.setInquireNum(inquireNum);
		dto.setInquireAnswer(inquireAnswer);
		dto.setEmpNum(auth.getUserNum());
		
		
		inquireMapper.inquireAnswerRegist(dto);
		
	}

}
