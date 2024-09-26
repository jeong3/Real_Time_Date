package GoodsService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.GoodsDAO;
import model.GoodsDTO;

public class GoodsListService {

	public void execute(HttpServletRequest request) {
		
		GoodsDAO dao = new GoodsDAO();
		List<GoodsDTO> list = dao.GoodsSelectAll();
		request.setAttribute("list", list);
	}

}
