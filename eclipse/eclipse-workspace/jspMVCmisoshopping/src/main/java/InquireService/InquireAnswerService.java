package InquireService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.EmployeeDAO;
import model.InquireDAO;
import model.InquireDTO;

public class InquireAnswerService {

	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String inquireNum = request.getParameter("inquireNum");
		String inquireAnswer = request.getParameter("inquireAnswer");
		
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		EmployeeDAO empDao = new EmployeeDAO();
		String empNum = empDao.employeeNumSelect(auth.getUserId());
		
		InquireDTO dto = new InquireDTO();
		dto.setInquireNum(Long.parseLong(inquireNum));
		dto.setInquireAnswer(inquireAnswer);
		dto.setEmpNum(empNum);
		
		InquireDAO dao = new InquireDAO();
		dao.inquireReplyUpdate(dto);
		
		
	}

}
