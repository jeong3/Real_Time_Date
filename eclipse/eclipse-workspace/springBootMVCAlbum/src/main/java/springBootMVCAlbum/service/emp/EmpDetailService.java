package springBootMVCAlbum.service.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCAlbum.domain.EmployeeDTO;
import springBootMVCAlbum.mapper.EmpMapper;

@Service
public class EmpDetailService {
	@Autowired
	EmpMapper EmpMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(String empNum, Model model) {
		EmployeeDTO dto = EmpMapper.empSelectOne(empNum);
		model.addAttribute("empPwCheck", dto.getEmpPw());
		model.addAttribute("empCommand", dto);
	}

}
