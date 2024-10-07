package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import board.command.BoardCommand;
import board.service.BoardListService;
import board.service.BoardWriteService;


@Controller
public class BoardController {
	@Autowired
	BoardWriteService boardWriteService;
	BoardListService boardListService;
	@RequestMapping("boardList")
	public String boardList(BoardCommand boardCommand) {
		boardListService.execute(boardCommand);
		return "thymeleaf/board/boardList";
	}
	
	@GetMapping("boardWrite")
	public String boardWrite() {
		return "thymeleaf/board/boardForm";
	}
	@PostMapping("boardWrite")
	public String boardWrite(BoardCommand boardCommand) {
		boardWriteService.execute(boardCommand);
		return "redirect:boardList";
	}
	
}
