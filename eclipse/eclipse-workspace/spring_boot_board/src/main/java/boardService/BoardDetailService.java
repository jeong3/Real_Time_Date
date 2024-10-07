package boardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import model.BoardDAO;
import model.BoardDTO;
@Service
public class BoardDetailService {
	@Autowired
	BoardDAO boardDAO;
	
	public void execute(HttpServletRequest request) {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		BoardDTO dto = boardDAO.BoardSelectOne(boardNum);
		request.setAttribute("dto", dto);
	}
	
}
