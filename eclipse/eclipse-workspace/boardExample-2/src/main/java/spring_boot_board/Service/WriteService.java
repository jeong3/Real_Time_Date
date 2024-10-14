package spring_boot_board.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_boot_board.Mapper.BoardMapper;
import spring_boot_board.command.command;
import spring_boot_board.domain.BoardDTO;

@Service
public class WriteService {
	@Autowired
	BoardMapper mapper;
	public void execute(command command) {
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(command.getBoardContent());
		dto.setBoardSubject(command.getBoardSubject());
		dto.setBoardWriter(command.getBoardWriter());
		mapper.Insert(dto);
	}
	
}
