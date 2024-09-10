package EmployeeService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.EmployeeDAO;
import model.EmployeeDTO;

public class EmployeeListService {

	public void execute(HttpServletRequest request) {
		EmployeeDAO dao = new EmployeeDAO();
		List<EmployeeDTO> list = dao.EmployeeSelectAll();
		request.setAttribute("list", list);
	}

}
