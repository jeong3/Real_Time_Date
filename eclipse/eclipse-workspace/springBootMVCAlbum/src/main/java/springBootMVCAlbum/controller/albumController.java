package springBootMVCAlbum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("album")
public class albumController {
	@GetMapping("KpopList")
	public String KpopList() {
		return "thymeleaf/kpop/kpopList";
	}
	@GetMapping("popAndRockList")
	public String popAndRockList() {
		return "thymeleaf/popAndRock/popAndRockList";
	}
	@GetMapping("classicList")
	public String classicList() {
		return "thymeleaf/classic/classicList";
	}
	@GetMapping("lpList")
	public String lpList() {
		return "thymeleaf/lp/lpList";
	}
}
