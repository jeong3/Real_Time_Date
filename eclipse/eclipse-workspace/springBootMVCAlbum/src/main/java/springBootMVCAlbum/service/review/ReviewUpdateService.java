package springBootMVCAlbum.service.review;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.ReviewCommand;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.domain.ReviewDTO;
import springBootMVCAlbum.mapper.ReviewInquiryMapper;

@Service
public class ReviewUpdateService {
	@Autowired
	ReviewInquiryMapper reviewMapper;
	public void execute(ReviewCommand reviewCommand, HttpSession session) {
	
		ReviewDTO dto = new ReviewDTO();
		BeanUtils.copyProperties(reviewCommand, dto);

		reviewMapper.ReviewUpdate(dto);
		
	}

}
