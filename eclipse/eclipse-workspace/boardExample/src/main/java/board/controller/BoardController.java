package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.command.BoardCommand;
import board.service.BoardDeleteService;
import board.service.BoardDetailService;
import board.service.BoardListService;
import board.service.BoardUpdateService;
import board.service.BoardWriteService;



@Controller
public class BoardController {
	
	@Autowired
	BoardListService boardListService;
	@RequestMapping("boardList")
	public String boardList(BoardCommand boardCommand, Model model) {
		boardListService.execute(boardCommand, model);
		//return "thymeleaf/board/boardList";
		return "boardList";
	}
	
	@GetMapping("boardWrite")
	public String boardWrite() {
		return "thymeleaf/board/boardForm";
	}
	@Autowired
	BoardWriteService boardWriteService;
	@PostMapping("boardWrite")
	public String boardWrite(BoardCommand boardCommand) {
		boardWriteService.execute(boardCommand);
		return "redirect:boardList";
	}
	
	@Autowired
	BoardDetailService boardDetailService;
	//@GetMapping(value = "boardDetail")
	//@GetMapping("boardDetail")
	@RequestMapping(value = "boardDetail", method = RequestMethod.GET)
	public String boardDetail(@RequestParam("boardNum") String boardNum, Model model) { //String boardNum = request.getParameter("boardNum")
		boardDetailService.execute(boardNum, model);
		return "thymeleaf/board/boardDetail";
	}
	
	@GetMapping("boardModify")
	public String boardModify(@RequestParam("boardNum") String boardNum , Model model) {
		boardDetailService.execute(boardNum, model);
		return "thymeleaf/board/boardUpdate";
	}
	
	//@PostMapping("boardModify")
	@Autowired
	BoardUpdateService boardUpdateService;
	@RequestMapping(value = "boardModify", method = RequestMethod.POST)
	public String boardModify(BoardCommand boardCommand) {
		boardUpdateService.execute(boardCommand);
		return "redirect:boardDetail?boardNum="+boardCommand.getBoardNum();
	}
	@Autowired
	BoardDeleteService boardDeleteService;
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam("boardNum") Integer boardNum) {
		boardDeleteService.execute(boardNum);
		return "redirect:boardList";
	}
	
	
	
	
}
