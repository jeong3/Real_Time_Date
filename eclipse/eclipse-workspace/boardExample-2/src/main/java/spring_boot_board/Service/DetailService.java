package spring_boot_board.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring_boot_board.Mapper.BoardMapper;
import spring_boot_board.domain.BoardDTO;

@Service
public class DetailService {
	@Autowired
	BoardMapper mapper;

	public void execute(Integer boardNum, Model model) {
		BoardDTO dto = mapper.SelectOne(boardNum);
		model.addAttribute("dto", dto);
	}
	
}
