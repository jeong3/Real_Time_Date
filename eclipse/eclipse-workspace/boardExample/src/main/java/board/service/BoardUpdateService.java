package board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.command.BoardCommand;
import board.domain.BoardDTO;
import board.mapper.BoardMapper;
@Service
public class BoardUpdateService {
	@Autowired
	BoardMapper boardMapper;
	public void execute(BoardCommand boardcommand) {
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(boardcommand.getBoardContent());
		dto.setBoardNum(boardcommand.getBoardNum());
		dto.setBoardSubject(boardcommand.getBoardSubject());
		dto.setBoardWriter(boardcommand.getBoardWriter());
		boardMapper.boardUpdate(dto);
		
	}
}
