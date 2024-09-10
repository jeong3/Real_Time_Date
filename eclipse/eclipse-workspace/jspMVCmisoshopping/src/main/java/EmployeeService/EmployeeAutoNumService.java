package EmployeeService;

import javax.servlet.http.HttpServletRequest;

import model.EmployeeDAO;

public class EmployeeAutoNumService {

	public void execute(HttpServletRequest request) {
		
		EmployeeDAO dao = new EmployeeDAO();
		String num = dao.EmployeeAutoNum();
		request.setAttribute("empNum", num);
	}

}
