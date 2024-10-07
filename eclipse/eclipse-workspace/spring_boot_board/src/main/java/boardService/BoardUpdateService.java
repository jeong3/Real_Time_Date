package boardService;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import model.BoardDAO;
import model.BoardDTO;
@Service
public class BoardUpdateService {
	@Autowired
	BoardDAO boardDAO;
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BoardDTO dto = new BoardDTO();
		dto.setBoardNum(Integer.parseInt(request.getParameter("boardNum")) );
		dto.setBoardWriter(request.getParameter("boardWriter"));
		dto.setBoardSubject(request.getParameter("boardSubject"));
		dto.setBoardContent(request.getParameter("boardContent"));
		boardDAO.BoardUpdate(dto);
	}

}
