package ItemService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Service.MemberAuthService;
import model.ItemDAO;
import model.PurchaseInfoDTO;

public class PurchaseListService extends MemberAuthService{
	public PurchaseListService(HttpServletRequest request) {
		super(request);
	}
	public void execute(HttpServletRequest request) {
		ItemDAO dao = new ItemDAO();
		List<PurchaseInfoDTO> list = dao.purchaseItemSelect(memberNum);
		System.out.println(list.size());
		request.setAttribute("list", list);
	}

}
