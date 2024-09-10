package EmployeeService;

import javax.servlet.http.HttpServletRequest;

import model.EmployeeDAO;

public class EmployeeDeleteService {

	public void execute(HttpServletRequest request) {
		String empNum = request.getParameter("empNum");
		EmployeeDAO dao = new EmployeeDAO();
		dao.employeeDelete(empNum);
	}

}
