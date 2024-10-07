package ReviewService;

import javax.servlet.http.HttpServletRequest;

import model.ReviewDAO;
import model.ReviewDTO;

public class ReviewDetailService {

	public void execute(HttpServletRequest request) {
		String purchaseNum = request.getParameter("purchaseNum");
		String goodsNum = request.getParameter("goodsNum");
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO dto = new ReviewDTO();
		dto.setGoodsNum(goodsNum);
		dto.setPurchaseNum(purchaseNum);
		dao.reviewSelectOne(dto);
		request.setAttribute("dto", dto);
		
	}

}
