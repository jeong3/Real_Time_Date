package springBootMVCShopping.service.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.EmployeeCommand;
import springBootMVCShopping.domain.EmpDTO;
import springBootMVCShopping.mapper.EmployeeMapper;

@Service
public class EmployeeWriteService {
	@Autowired
	EmployeeMapper empMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(EmployeeCommand empCommand) {
		EmpDTO dto = new EmpDTO();
		dto.setEmpAddr(empCommand.getEmpAddr());
		dto.setEmpAddrDetail(empCommand.getEmpAddrDetail());
		dto.setEmpEmail(empCommand.getEmpEmail());
		dto.setEmpId(empCommand.getEmpId());
		dto.setEmpJumin(empCommand.getEmpJumin().trim());
		dto.setEmpName(empCommand.getEmpName());
		dto.setEmpNum(empCommand.getEmpNum());
		dto.setEmpPhone(empCommand.getEmpPhone().trim());
		dto.setEmpPost(empCommand.getEmpPost());
		
		String encodePw = passwordEncoder.encode(empCommand.getEmpPw());
		dto.setEmpPw(encodePw);
		
		empMapper.empInsert(dto);
	}
	
}
