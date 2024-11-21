package springBootMVCAlbum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class memberController {
	@GetMapping("memberList")
	public String memberList() {
		return "thymeleaf/member/memberList";
	}
	@GetMapping("memberRegist")
	public String memberRegist() {
		return "thymeleaf/member/memberRegist";
	}
}
