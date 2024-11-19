package springBootMVCShopping.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCShopping.domain.InquireDTO;
import springBootMVCShopping.repository.InquireRepository;
import springBootMVCShopping.service.item.GoodsDetailViewService;

@Controller
@RequestMapping("corner")
public class CornerController {
	@Autowired
	GoodsDetailViewService goodsDetailViewService;

	@GetMapping("detailView/{goodsNum}")
	public String detailView(@PathVariable("goodsNum") String goodsNum, Model model, HttpServletResponse response, HttpSession session,  boolean visit) {
		goodsDetailViewService.execute(goodsNum,model,response, session, true);
		return "thymeleaf/item/detailView";
	}
	@RequestMapping("goodsDescript")
	public void goodsDescript(@RequestBody Map<String, String> map , Model model, HttpServletResponse response, HttpSession session,  boolean visit) {
		goodsDetailViewService.execute(map.get("goodsNum") , model, response, session, false);
	}
	@Autowired
	InquireRepository inquireRepository;
	
	@RequestMapping("inquireList")
	public String inquireList(@ModelAttribute(value="goodsNum") String goodsNum, Model model) {
		List<InquireDTO> list = inquireRepository.inquireList(goodsNum, null);
		model.addAttribute("list", list);
		model.addAttribute("newLineChar", "/n");
		return "thymeleaf/inquire/inquireList";
	}
}
