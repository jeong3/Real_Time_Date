package EmployeeService;

import javax.servlet.http.HttpServletRequest;

import model.EmployeeDAO;
import model.EmployeeDTO;

public class EmployeeDetailService {

	public void execute(HttpServletRequest request) {
		String empNum = request.getParameter("empNum");
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = dao.employeeSelectOne(empNum);
		request.setAttribute("dto", dto);
		
		
	}

}
