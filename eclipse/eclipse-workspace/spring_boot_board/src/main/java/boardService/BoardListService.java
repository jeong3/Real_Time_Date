package boardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import model.BoardDAO;
import model.BoardDTO;
@Service
public class BoardListService {
	@Autowired
	BoardDAO boardDAO;
	public void execute(HttpServletRequest request) {
		List<BoardDTO> list = boardDAO.boardSelectAll();
		request.setAttribute("list", list);
	}
}
