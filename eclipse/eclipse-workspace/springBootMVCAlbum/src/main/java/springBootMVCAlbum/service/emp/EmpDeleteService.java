package springBootMVCAlbum.service.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCAlbum.mapper.EmpMapper;

@Service
public class EmpDeleteService {
	@Autowired
	EmpMapper empMapper;

	public void execute(String empNum) {
		empMapper.empDelete(empNum);
	}
	
}
