package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.ReviewDTO;
import springBootMVCShopping.repository.ReviewRepository;

@Controller
@RequestMapping("review")
public class ReviewController {
	@Autowired
	ReviewRepository reviewRepository;
	@RequestMapping(value = "goodsReview", method = RequestMethod.GET)
	public String goodsReview(String goodsNum, String purchaseNum, Model model , HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");

		ReviewDTO dto = new ReviewDTO();
		dto.setMemberId(auth.getUserId());
		dto.setGoodsNum(goodsNum);
		dto.setPurchaseNum(purchaseNum);
		String reviewContents = reviewRepository.reviewSelectOne(dto);
		model.addAttribute("reviewContents", reviewContents);
		model.addAttribute("dto", dto);
		return "thymeleaf/review/goodsReview";
	}
	@RequestMapping("reviewWrite")
	public String reviewWrite(ReviewDTO dto, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		dto.setMemberId(auth.getUserId());
		reviewRepository.reviewUpdate(dto);
		return "redirect:/purchase/orderList";
	}
}
