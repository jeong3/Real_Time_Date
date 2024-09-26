package ItemService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Service.MemberAuthService;
import model.CartListDTO;
import model.ItemDAO;

public class CartListService extends MemberAuthService {

	public CartListService(HttpServletRequest request) {
		super(request);
	}

	public void execute(HttpServletRequest request) {
		ItemDAO dao = new ItemDAO();
		List<CartListDTO> list = dao.cartSelectList(memberNum);
		request.setAttribute("list", list);
		
	}

}
