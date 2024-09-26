package ItemService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.CartDTO;
import model.ItemDAO;
import model.MemberDAO;

public class CartMergeService {

	public void execute(HttpServletRequest request) {
		 try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		String goodsNum = request.getParameter("goodsNum");
		String cartQty = request.getParameter("cartQty");
		
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		MemberDAO memDao = new MemberDAO();
		String memberNum = memDao.memberNumSelect(auth.getUserId());
		
		CartDTO dto = new CartDTO();
		dto.setMemberNum(memberNum);
		dto.setGoodsNum(goodsNum);
		dto.setCartQty(Integer.parseInt(cartQty));
		
		ItemDAO dao = new ItemDAO();
		dao.cartMerge(dto);
		
	}

}
