package spring_boot_board.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_boot_board.Mapper.BoardMapper;
import spring_boot_board.command.command;
import spring_boot_board.domain.BoardDTO;

@Service
public class UpdateService {
	@Autowired
	BoardMapper mapper;

	public void execute(command cmd) {
		BoardDTO dto = new BoardDTO();
		dto.setBoardNum(cmd.getBoardNum());
		dto.setBoardContent(cmd.getBoardContent());
		dto.setBoardSubject(cmd.getBoardSubject());
		dto.setBoardWriter(cmd.getBoardWriter());
		mapper.Update(dto);
		
	}
	
}
