package boardService;

import javax.servlet.http.HttpServletRequest;

import model.BoardDAO;
import model.BoardDTO;

public class BoardUpdateService {

	public void execute(HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setBoardNum(Integer.parseInt(request.getParameter("boardNum")) );
		dto.setBoardWriter(request.getParameter("boardWriter"));
		dto.setBoardSubject(request.getParameter("boardSubject"));
		dto.setBoardContent(request.getParameter("boardContent"));
		BoardDAO dao = new BoardDAO();
		dao.BoardUpdate(dto);
	}

}
