package boardService;

import javax.servlet.http.HttpServletRequest;

import model.BoardDAO;
import model.BoardDTO;

public class BoardDetailService {

	public void execute(HttpServletRequest request) {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.BoardSelectOne(boardNum);
		request.setAttribute("dto", dto);
	}
	
}
