package springBootMVCShopping.service.myPage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.EmployeeDTO;
import springBootMVCShopping.mapper.EmployeeInfoMapper;

@Service
public class EmployeeInfoService {
	@Autowired
	EmployeeInfoMapper employeeInfoMapper; 
	
	public Map<String, Object> execute(HttpSession session, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		EmployeeDTO dto = employeeInfoMapper.employeeSelectOne(auth.getUserId());
		System.out.println(dto.getEmpAddr()+"인포서비스");
		model.addAttribute("employeeCommand", dto);
		map.put("employeeCommand", dto);
		return map;
	}
}