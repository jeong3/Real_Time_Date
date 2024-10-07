package ReviewService;

import javax.servlet.http.HttpServletRequest;

import model.ReviewDAO;

public class ReviewDeleteService {

	public void execute(HttpServletRequest request) {
		String reviewNum = request.getParameter("reviewNum");
		ReviewDAO dao = new ReviewDAO();
		dao.reviewDelete(reviewNum);
	}

}
