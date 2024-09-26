package ItemService;

import javax.servlet.http.HttpServletRequest;

import Service.MemberAuthService;
import model.ItemDAO;

public class CartQtyDownService extends MemberAuthService{

	public CartQtyDownService(HttpServletRequest request) {
		super(request);
	}

	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		ItemDAO dao = new ItemDAO();
		dao.itemQtyDownUpdate(goodsNum,memberNum);
		
	}
	

	

}
