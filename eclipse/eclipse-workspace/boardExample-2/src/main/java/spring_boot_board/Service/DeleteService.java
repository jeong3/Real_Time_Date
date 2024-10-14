package spring_boot_board.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_boot_board.Mapper.BoardMapper;

@Service
public class DeleteService {
	@Autowired
	BoardMapper mapper;

	public void execute(Integer boardNum) {
		mapper.Delete(boardNum);
	}
	
}
