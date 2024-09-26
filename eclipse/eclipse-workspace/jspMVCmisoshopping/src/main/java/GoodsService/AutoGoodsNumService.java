package GoodsService;

import javax.servlet.http.HttpServletRequest;

import model.GoodsDAO;
import model.GoodsDTO;

public class AutoGoodsNumService {

	public void execute(HttpServletRequest request) {
		GoodsDAO dao = new GoodsDAO();
		String num = dao.AutoGoodsNum();
		request.setAttribute("goodsNum", num);
		
	}

}
