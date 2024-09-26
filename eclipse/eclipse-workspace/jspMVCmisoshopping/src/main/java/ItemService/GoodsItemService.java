package ItemService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Service.MemberAuthService;
import model.CartListDTO;
import model.ItemDAO;

public class GoodsItemService extends MemberAuthService{

	public GoodsItemService(HttpServletRequest request) {
		super(request);
	}
	public void execute(HttpServletRequest request) {
		String goodsNums[] = request.getParameterValues("prodCk");
		List<CartListDTO> list = new ArrayList<CartListDTO>();
		ItemDAO dao = new ItemDAO();
		Integer goodsTotalPrice = 0;
		String nums = "";
		for(String goodsNum : goodsNums) {
			CartListDTO dto = dao.itemSelectOne(goodsNum, memberNum);
			list.add(dto);
			goodsTotalPrice += dto.getTotalPrice();
			nums += goodsNum+"-";
		}
		request.setAttribute("list", list);
		request.setAttribute("goodsTotalPrice", goodsTotalPrice);
		request.setAttribute("goodsNums", nums);
		
	}
	

}
