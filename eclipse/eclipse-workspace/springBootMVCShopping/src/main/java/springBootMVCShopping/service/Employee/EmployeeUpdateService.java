package springBootMVCShopping.service.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.EmployeeCommand;
import springBootMVCShopping.domain.EmpDTO;
import springBootMVCShopping.mapper.EmployeeMapper;

@Service
public class EmployeeUpdateService {
	@Autowired
	EmployeeMapper empMapper;

	public void execute(EmployeeCommand empcommand) {
		EmpDTO dto = new EmpDTO();
		dto.setEmpAddr(empcommand.getEmpAddr());
		dto.setEmpAddrDetail(empcommand.getEmpAddrDetail());
		dto.setEmpEmail(empcommand.getEmpEmail());
		dto.setEmpId(empcommand.getEmpId());
		dto.setEmpJumin(empcommand.getEmpJumin());
		dto.setEmpName(empcommand.getEmpName());
		dto.setEmpNum(empcommand.getEmpNum());
		dto.setEmpPhone(empcommand.getEmpPhone());
		dto.setEmpPost(empcommand.getEmpPost());
		dto.setEmpPw(empcommand.getEmpPw());
		
		empMapper.empUpdate(dto);
	}
	
}
