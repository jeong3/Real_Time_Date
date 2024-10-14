package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring_boot_board.Service.DeleteService;
import spring_boot_board.Service.DetailService;
import spring_boot_board.Service.ListService;
import spring_boot_board.Service.UpdateService;
import spring_boot_board.Service.WriteService;
import spring_boot_board.command.command;

@Controller
public class controller {
	@Autowired
	WriteService writeService;
	@Autowired
	ListService listService;
	@Autowired 
	DetailService detailService;
	@Autowired
	UpdateService updateService;
	@Autowired
	DeleteService deleteService;
	
	@GetMapping("boardList")
	public String List(Model model) {
		listService.execute(model);
		return "thymeleaf/board/boardList";
	}
	@GetMapping("boardWrite")
	public String Write() {
		
		return "thymeleaf/board/boardForm";
	}
	
	@PostMapping("boardWrite")
	public String Write(command command) {
		writeService.execute(command);
		return "redirect:boardList";
	}
	@GetMapping("boardDetail")
	public String boardDetail(@RequestParam("boardNum") Integer boardNum, Model model) {
		detailService.execute(boardNum, model);
		return "thymeleaf/board/boardDetail";
	}
	@GetMapping("boardModify")
	public String boardModify(@RequestParam("boardNum") Integer boardNum, Model model) {
		detailService.execute(boardNum, model);
		return "thymeleaf/board/boardModify";
	}
	@PostMapping("boardModify")
	public String boardModify(command cmd) {
		updateService.execute(cmd);	
		return "redirect:boardDetail?boardNum="+cmd.getBoardNum();
	}
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam("boardNum") Integer boardNum) {
		deleteService.execute(boardNum);
		return "redirect:boardList";
	}
	
	
}
