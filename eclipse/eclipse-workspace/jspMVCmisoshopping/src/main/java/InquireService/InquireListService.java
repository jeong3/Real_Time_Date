package InquireService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Service.MemberAuthService;
import model.InquireDAO;
import model.InquireDTO;

public class InquireListService extends MemberAuthService{
	public InquireListService(HttpServletRequest request) {
		super(request);
	}

	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		InquireDAO dao = new InquireDAO();
		List<InquireDTO> list = dao.inquireSelectAll(goodsNum);
		request.setAttribute("list", list);
		request.setAttribute("newLine", "\n");
		
		if(auth != null) {
			request.setAttribute("memberNum", memberNum);
		}
		
	}

}
