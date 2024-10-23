package springBootMVCShopping.service.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.EmployeeDTO;
import springBootMVCShopping.domain.StartEndPageDTO;
import springBootMVCShopping.mapper.EmployeeMapper;
import springBootMVCShopping.service.StartEndPageService;

@Service
public class EmployeeListService {
	@Autowired
	EmployeeMapper empMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(Integer page, String searchWord, Model model) {
		Integer limit = 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, searchWord, limit);
		List<EmployeeDTO> list = empMapper.empSelectList(sepDTO);
		model.addAttribute("list", list);
		Integer count = empMapper.empCount();
		startEndPageService.execute(page, limit, count, searchWord, list, model);
		
	}
	
}
