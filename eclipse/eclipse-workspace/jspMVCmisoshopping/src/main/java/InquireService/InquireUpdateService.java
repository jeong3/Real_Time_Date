package InquireService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.InquireDAO;
import model.InquireDTO;

public class InquireUpdateService {

	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String inquireNum = request.getParameter("inquireNum");
		String inquireSubject = request.getParameter("inquireSubject");
		String inquireContent = request.getParameter("inquireContent");
		String queryType = request.getParameter("queryType");
		
		InquireDTO dto = new InquireDTO();
		dto.setInquireContent(inquireContent);
		dto.setInquireKind(queryType);
		dto.setInquireSubject(inquireSubject);
		dto.setInquireNum(Long.parseLong(inquireNum));
		InquireDAO dao = new InquireDAO();
		dao.inquireUpdate(dto);
	}

}
