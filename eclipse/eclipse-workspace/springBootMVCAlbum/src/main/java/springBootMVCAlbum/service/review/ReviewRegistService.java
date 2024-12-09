package springBootMVCAlbum.service.review;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.ReviewCommand;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.domain.ReviewDTO;
import springBootMVCAlbum.mapper.ReviewInquiryMapper;

@Service
public class ReviewRegistService {
	@Autowired
	ReviewInquiryMapper reviewMapper;

	public void execute(ReviewCommand reviewCommand, HttpSession session) {

		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberId = auth.getUserId();

		ReviewDTO dto = new ReviewDTO();
		BeanUtils.copyProperties(reviewCommand, dto);

		dto.setMemberId(memberId);

		reviewMapper.ReviewInsert(dto);

	}

}
