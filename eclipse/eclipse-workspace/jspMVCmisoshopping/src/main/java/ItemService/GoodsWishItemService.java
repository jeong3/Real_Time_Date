package ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.ItemDAO;
import model.MemberDAO;

public class GoodsWishItemService {

	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		MemberDAO dao = new MemberDAO();
		String memberNum = dao.memberNumSelect(auth.getUserId());
		
		ItemDAO idao = new ItemDAO();
		idao.wishItem(memberNum, goodsNum);
		
	}
}
