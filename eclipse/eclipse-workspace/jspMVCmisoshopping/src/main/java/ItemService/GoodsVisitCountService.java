package ItemService;

import javax.servlet.http.HttpServletRequest;

import model.GoodsDAO;

public class GoodsVisitCountService {

	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		dao.visitCount(goodsNum);
		
	}

}
