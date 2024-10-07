package boardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import model.BoardDAO;
@Service
public class BoardDeleteService {
	@Autowired
	BoardDAO boardDAO;
	
	public void execute(HttpServletRequest request) {
		int boardNum = Integer.parseInt(request.getParameter("boardNum")) ;
		boardDAO.boardDelete(boardNum);
		
	}
	
}
