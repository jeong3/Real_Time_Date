package springBootMVCAlbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.IpgoCommand;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.mapper.IpgoMapper;
import springBootMVCAlbum.service.AutoNumService;
import springBootMVCAlbum.service.ipgo.IpgoDetailService;
import springBootMVCAlbum.service.ipgo.IpgoListService;
import springBootMVCAlbum.service.ipgo.IpgoRegistService;
import springBootMVCAlbum.service.ipgo.IpgoUpdateService;

@Controller
@RequestMapping("ipgo")
public class GoodsIpgoController {
	@Autowired
	IpgoRegistService ipgoRegistService;
	@Autowired
	IpgoListService ipgoListService;
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	IpgoDetailService ipgoDetailService;
	@Autowired
	IpgoUpdateService ipgoUpdateService;
	@Autowired
	IpgoMapper ipgoMapper;
	
	@GetMapping("ipgoList")
	public String ipgoList(Model model) {
		ipgoListService.execute(model);
		return "thymeleaf/ipgo/ipgoList";
	}
	@GetMapping("ipgoRegist")
	public String ipgoRegist( HttpSession session, Model model) {
		String autoNum = autoNumService.execute("ipgo_", "ipgo_num", 6, "goods_ipgo");
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empNum = auth.getUserNum();
		model.addAttribute("autoNum", autoNum);
		model.addAttribute("empNum", empNum);
		return "thymeleaf/ipgo/ipgoRegist";
	}
	@PostMapping("ipgoRegist")
	public String ipgoRegist(@ModelAttribute IpgoCommand ipgoCommand) {
		ipgoCommand.setIpgoDate(null);
		ipgoRegistService.execute(ipgoCommand);
		
		return "redirect:ipgoList";
	}
	@GetMapping("ipgoUpdate")
	public String ipgoUpdate(String ipgoNum ,Model model) {
		ipgoDetailService.execute(ipgoNum, model);
		return "thymeleaf/ipgo/ipgoUpdate";
	}
	@PostMapping("ipgoUpdate")
	public String ipgoUpdate(@ModelAttribute IpgoCommand ipgoCommand, HttpSession session) {
		ipgoCommand.setIpgoDate(null);
		ipgoUpdateService.execute(ipgoCommand, session);
		return "redirect:ipgoList";
	}
	@GetMapping("ipgoDelete")
	public String ipgoDelete(String ipgoNum) {
		ipgoMapper.ipgoDelete(ipgoNum);
		return "redirect:ipgoList";
	}
}
