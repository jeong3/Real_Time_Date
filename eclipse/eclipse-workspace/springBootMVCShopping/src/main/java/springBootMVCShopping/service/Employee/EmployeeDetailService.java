package springBootMVCShopping.service.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.EmpDTO;
import springBootMVCShopping.mapper.EmployeeMapper;

@Service
public class EmployeeDetailService {
	@Autowired
	EmployeeMapper empMapper;
	public void execute(String empNum, Model model) {
		EmpDTO dto = empMapper.empSelectOne(empNum);
		model.addAttribute("employeeCommand", dto);
	}

}
