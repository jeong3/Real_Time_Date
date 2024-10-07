package boardService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import model.BoardDAO;
import model.BoardDTO;

public class BoardDetailService {
	@Autowired
	BoardDAO boardDAO;
	
	public void execute(HttpServletRequest request) {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		BoardDTO dto = boardDAO.BoardSelectOne(boardNum);
		request.setAttribute("dto", dto);
	}
	
}
