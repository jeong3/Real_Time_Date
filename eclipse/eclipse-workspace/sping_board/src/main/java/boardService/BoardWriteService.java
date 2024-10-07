package boardService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import model.BoardDAO;
import model.BoardDTO;

public class BoardWriteService {

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
		dto.setBoardWriter(request.getParameter("boardWriter"));
		dto.setBoardSubject(request.getParameter("boardSubject"));
		dto.setBoardContent(request.getParameter("boardContent"));
		boardDAO.boardInsert(dto);
		
	}

}
