package springBootMVCAlbum.service.emp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springBootMVCAlbum.command.EmpCommand;
import springBootMVCAlbum.domain.EmployeeDTO;
import springBootMVCAlbum.mapper.EmpMapper;

@Service
public class EmpRegistService {
	@Autowired
	EmpMapper empMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(EmpCommand empCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(empCommand, dto);
		String encodePw = passwordEncoder.encode(empCommand.getEmpPw());
		dto.setEmpPw(encodePw);
		
		empMapper.empInsert(dto);
		
	}
}
