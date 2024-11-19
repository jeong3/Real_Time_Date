package springBootMVCShopping.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.ReviewDTO;
import springBootMVCShopping.repository.ReviewRepository;

@Controller
@RequestMapping("review")
public class ReviewController {
	@Autowired
	ReviewRepository reviewRepository;

	@RequestMapping(value = "goodsReview", method = RequestMethod.GET)
	public String goodsReview(String goodsNum, String purchaseNum, ReviewDTO dto, Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		dto.setMemberId(auth.getUserId());
		dto.setGoodsNum(goodsNum);
		dto.setPurchaseNum(purchaseNum);

		ReviewDTO dto1 = reviewRepository.reviewSelectOne(dto);
		if (dto1 != null) {
			dto.setReviewContents(dto1.getReviewContents());
		}

		model.addAttribute("dto", dto);
		return "thymeleaf/review/goodsReview";
	}

	@RequestMapping("reviewWrite")
	public String reviewWrite(ReviewDTO dto, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		dto.setMemberId(auth.getUserId());
		ReviewDTO dto1 = reviewRepository.reviewSelectOne(dto);
		if (dto1 == null) {
				System.out.println("인설트");
				reviewRepository.reviewInsert(dto);
		} else {
			System.out.println("업데이트");
			reviewRepository.reviewUpdate(dto);
		}
		
		
		return "redirect:/purchase/orderList";
	}

	@PostMapping("reviewList")
	public ResponseEntity<Map<String, Object>> reviewList(@RequestBody Map<String, String> map, Model model) {

		String goodsNum = map.get("goodsNum");
		List<ReviewDTO> list = reviewRepository.goodsReviewList(goodsNum);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("reviews", list);
		return ResponseEntity.ok(response);
	}

}
