package EmployeeService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.EmployeeDAO;
import model.EmployeeDTO;

public class EmployeeUpdateService {

	public int execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		EmployeeDAO dao = new EmployeeDAO();
		String empNum = request.getParameter("empNum");
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		if(empNum == null) {
			empNum = dao.employeeNumSelect(auth.getUserId());
			System.out.println(empNum);
		}
		
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpNum(empNum);
		dto.setEmpId(request.getParameter("empId"));
		dto.setEmpPw(request.getParameter("empPw"));
		dto.setEmpName(request.getParameter("empName"));
		dto.setEmpAddr(request.getParameter("empAddr"));
		dto.setEmpAddrDetail(request.getParameter("empAddrDetail"));
		dto.setEmpPost(request.getParameter("empPost"));
		dto.setEmpPhone(request.getParameter("empPhone"));
		dto.setEmpJumin(request.getParameter("empJumin"));
		dto.setEmpEmail(request.getParameter("empEmail"));
		
		int i = 0;
		if(auth.getUserPw().equals(request.getParameter("empPw"))) {
			dao.employeeUpdate(dto);
			i = 1;
		}else {
			request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
			
		}return i;
		
		
	}



}
