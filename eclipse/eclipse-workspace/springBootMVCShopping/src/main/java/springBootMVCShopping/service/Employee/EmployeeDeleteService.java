package springBootMVCShopping.service.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.mapper.EmployeeMapper;

@Service
public class EmployeeDeleteService {
	@Autowired
	EmployeeMapper empMapper;
	public void execute(String[] empNum) {
		empMapper.empDelete(empNum);
	}
	
}
