package boardService;

import javax.servlet.http.HttpServletRequest;

import model.BoardDAO;
import model.BoardDTO;

public class BoardWriteService {

	public void execute(HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setBoardWriter(request.getParameter("boardWriter"));
		dto.setBoardSubject(request.getParameter("boardSubject"));
		dto.setBoardContent(request.getParameter("boardContent"));
		BoardDAO dao = new BoardDAO();
		dao.boardInsert(dto);
		
	}

}
