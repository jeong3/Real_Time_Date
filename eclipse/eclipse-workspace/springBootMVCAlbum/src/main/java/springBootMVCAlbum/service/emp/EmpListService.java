package springBootMVCAlbum.service.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCAlbum.domain.EmployeeDTO;
import springBootMVCAlbum.mapper.EmpMapper;

@Service
public class EmpListService {
	@Autowired
	EmpMapper empMapper;

	public void execute(Model model) {
		List<EmployeeDTO> list = empMapper.empSelectAll();
		
		model.addAttribute("list", list);
	}
}
