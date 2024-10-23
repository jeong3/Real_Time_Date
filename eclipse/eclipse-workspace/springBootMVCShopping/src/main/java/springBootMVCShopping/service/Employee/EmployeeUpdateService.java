package springBootMVCShopping.service.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.EmployeeCommand;
import springBootMVCShopping.domain.EmployeeDTO;
import springBootMVCShopping.mapper.EmployeeMapper;

@Service
public class EmployeeUpdateService {
	@Autowired
	EmployeeMapper empMapper;

	public void execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpAddr(employeeCommand.getEmpAddr());
		dto.setEmpAddrDetail(employeeCommand.getEmpAddrDetail());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpId(employeeCommand.getEmpId());
		dto.setEmpJumin(employeeCommand.getEmpJumin());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpNum(employeeCommand.getEmpNum());
		dto.setEmpPhone(employeeCommand.getEmpPhone());
		dto.setEmpPost(employeeCommand.getEmpPost());
		dto.setEmpPw(employeeCommand.getEmpPw());
		dto.setEmpHireDate(employeeCommand.getEmpHireDate());
		
		empMapper.empUpdate(dto);
	}
	
}
