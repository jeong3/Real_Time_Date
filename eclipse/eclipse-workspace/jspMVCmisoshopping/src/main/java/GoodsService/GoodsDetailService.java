package GoodsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.GoodsDAO;
import model.GoodsDTO;
import model.ItemDAO;
import model.MemberDAO;

public class GoodsDetailService {

	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.GoodsSelectOne(goodsNum);
		request.setAttribute("dto", dto);
		
		
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		if(auth != null) {
			MemberDAO memDao = new MemberDAO();
			String memberNum = memDao.memberNumSelect(auth.getUserId());
			ItemDAO itemDao = new ItemDAO();
			if(memberNum != null) {
				int i = itemDao.wishSelectOne(memberNum, goodsNum);
				if (i == 1) request.setAttribute("isTrue", "찜목록에 있음");
			}
		}
	}

}
