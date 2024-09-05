package boardService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.BoardDAO;
import model.BoardDTO;

public class BoardListService {
	public void execute(HttpServletRequest request) {
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.boardSelectAll();
		request.setAttribute("list", list);
	}
}
