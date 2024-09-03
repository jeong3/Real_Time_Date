package board1.service;


import javax.servlet.http.HttpServletRequest;

import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardUpdateService {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
		dto.setBoardWrite(request.getParameter("boardWriter"));
		dto.setBoardSubject(request.getParameter("boardSubject"));
		dto.setBoardContent(request.getParameter("boardContent"));
		BoardDAO dao = new BoardDAO();
		dao.boardUpdate(dto);
		
	}
}
