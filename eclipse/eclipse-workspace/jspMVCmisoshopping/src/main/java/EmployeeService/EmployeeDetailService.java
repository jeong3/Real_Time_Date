package EmployeeService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.EmployeeDAO;
import model.EmployeeDTO;

public class EmployeeDetailService {

	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmployeeDAO dao = new EmployeeDAO();
		String empNum = request.getParameter("empNum");
		if(empNum == null) {
			HttpSession session = request.getSession();
			AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
			String empId = auth.getUserId();
			empNum = dao.employeeNumSelect(empId);
			session.setAttribute("empNum", empNum);
		}
		
		
		
		
		
	}

}
