package EmployeeService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.EmployeeDAO;
import model.EmployeeDTO;

public class EmployeeWriteService {

	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpNum(request.getParameter("empNum"));
		dto.setEmpId(request.getParameter("empId"));
		dto.setEmpPw(request.getParameter("empPw"));
		dto.setEmpName(request.getParameter("empName"));
		dto.setEmpAddr(request.getParameter("empAddr"));
		dto.setEmpAddrDetail(request.getParameter("empAddrDetail"));
		dto.setEmpPost(request.getParameter("empPost"));
		dto.setEmpPhone(request.getParameter("empPhone"));
		dto.setEmpJumin(request.getParameter("empJumin"));
		dto.setEmpEmail(request.getParameter("empEmail"));
		EmployeeDAO dao = new EmployeeDAO();
		dao.employeeInsert(dto);
		
	}

}
