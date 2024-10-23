package springBootMVCShopping.service.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.EmployeeCommand;
import springBootMVCShopping.domain.EmployeeDTO;
import springBootMVCShopping.mapper.EmployeeMapper;

@Service
public class EmployeeWriteService {
	@Autowired
	EmployeeMapper empMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpAddr(employeeCommand.getEmpAddr());
		dto.setEmpAddrDetail(employeeCommand.getEmpAddrDetail());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpId(employeeCommand.getEmpId());
		dto.setEmpJumin(employeeCommand.getEmpJumin().trim());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpNum(employeeCommand.getEmpNum());
		dto.setEmpPhone(employeeCommand.getEmpPhone().trim());
		dto.setEmpPost(employeeCommand.getEmpPost());
		
		String encodePw = passwordEncoder.encode(employeeCommand.getEmpPw());
		dto.setEmpPw(encodePw);
		
		empMapper.empInsert(dto);
	}
	
}
