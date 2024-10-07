package BoardController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import boardService.BoardDeleteService;
import boardService.BoardDetailService;
import boardService.BoardListService;
import boardService.BoardUpdateService;
import boardService.BoardWriteService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardFrontController {
	@Autowired
	BoardListService boardListService;
	BoardDetailService boardDetailService;
	BoardDeleteService boardDeleteService;
	BoardWriteService boardWriteService;
	BoardUpdateService boardUpdateService;
	
	@GetMapping("boardList.com")
	public String boardList(HttpServletRequest request) {
		boardListService.execute(request);
		return "boardList";
	}
	@GetMapping("boardWrite.com")
	public String boardWrite() {
		return "boardForm";
	}
	@RequestMapping("boardDetail.com")
	public String boardDetail(HttpServletRequest request) {
		boardDetailService.execute(request);
		return "boardDetail";
	}
	@GetMapping("boardModify.com")
	public String boardModify(HttpServletRequest request) {
		boardDetailService.execute(request);
		return "boardUpdate";
	}
	@GetMapping("boardDelete.com")
	public String boardDelete(HttpServletRequest request) {
		boardDeleteService.execute(request);
		return "redirect:boardList.com";
	}
	@PostMapping("boardWrite.com")
	public String boardWrite(HttpServletRequest request) {
		boardWriteService.execute(request);
		return "redirect:boardList.com";
	}
	@PostMapping("boardModify.com")
	public String boardModify1(HttpServletRequest request) {
		boardUpdateService.execute(request);
		return "redirect:boardDetail.com?boardNum="+request.getParameter("boardNum");
	}
	
	
	
}
