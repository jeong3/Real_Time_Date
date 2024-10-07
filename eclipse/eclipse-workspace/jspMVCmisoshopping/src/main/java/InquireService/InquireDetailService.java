package InquireService;

import javax.servlet.http.HttpServletRequest;

import model.InquireDAO;
import model.InquireDTO;

public class InquireDetailService {

	public void execute(HttpServletRequest request) {
		String inquireNum = request.getParameter("inquireNum");
		InquireDAO dao = new InquireDAO();
		InquireDTO dto = new InquireDTO();
		dto.setInquireNum(Long.parseLong(inquireNum));
		dao.inquireSelectOne(dto);
		request.setAttribute("dto", dto);
	}

}
