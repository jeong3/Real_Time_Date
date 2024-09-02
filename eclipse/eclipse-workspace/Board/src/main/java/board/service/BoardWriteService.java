package board.service;

import javax.servlet.http.HttpServletRequest;

import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardWriteService {
	public void execute(HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(request.getParameter("boardContent"));
		dto.setBoardSubject(request.getParameter("boardSubject"));
		dto.setBoardWriter(request.getParameter("boardWriter"));
		BoardDAO dao = new BoardDAO();
		dao.boardInsert(dto);
	}
}
