package spring_boot_board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring_boot_board.Mapper.BoardMapper;
import spring_boot_board.domain.BoardDTO;

@Service
public class ListService {
	@Autowired
	BoardMapper mapper;

	public void execute(Model model) {
		
		List<BoardDTO> list = mapper.SelectAll();
		model.addAttribute("list", list);
		
	}
	
	
}
