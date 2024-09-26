package ItemService;

import javax.servlet.http.HttpServletRequest;

import Service.MemberAuthService;
import model.ItemDAO;

public class cartItemsDeleteService extends MemberAuthService{

	public cartItemsDeleteService(HttpServletRequest request) {
		super(request);
	}

	public void execute(HttpServletRequest request) {
		String goodsNums = request.getParameter("goodsNums");
		String goodsNumbers [] = goodsNums.split("-"); 
		ItemDAO dao = new ItemDAO();
		for(String goodsNum : goodsNumbers) {
			dao.itemDelete(goodsNum,memberNum);
		}
	}
}
