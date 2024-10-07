package ReviewService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.ReviewDAO;
import model.ReviewDTO;

public class ReviewListService {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		ReviewDAO dao = new ReviewDAO();
		List<ReviewDTO> list = dao.reviewSelectAll(goodsNum);
		request.setAttribute("list", list);
		request.setAttribute("newLine", "\n");
	}

}
