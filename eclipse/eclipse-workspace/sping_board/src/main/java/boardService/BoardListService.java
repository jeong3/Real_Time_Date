package boardService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import model.BoardDAO;
import model.BoardDTO;

public class BoardListService {
	@Autowired
	BoardDAO boardDAO;
	public void execute(HttpServletRequest request) {
		List<BoardDTO> list = boardDAO.boardSelectAll();
		request.setAttribute("list", list);
	}
}
