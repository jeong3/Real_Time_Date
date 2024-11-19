package springBootMVCShopping.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.InquireDTO;
import springBootMVCShopping.mapper.GoodsMapper;
import springBootMVCShopping.mapper.MemberMapper;
import springBootMVCShopping.repository.InquireRepository;

@Controller
@RequestMapping("inquire")
public class InquireController {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	InquireRepository inquireRepository;
	
	
	@GetMapping("inquireWrite")
	public String inquireWrite(@ModelAttribute(value="goodsNum") String goodsNum) {	
		return "thymeleaf/inquire/inquireWrite";
	}
	@PostMapping("inquireWrite")
	public void inquireWrite(InquireDTO dto, HttpSession session, HttpServletResponse response) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = memberMapper.memberNumSelect(auth.getUserId());
		dto.setMemberNum(memberNum);
		inquireRepository.inquireInsert(dto);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			String str = "<script>"
					+ "opener.parent.inquire();"
					+ "window.self.close();"
					+ "</script>";
			out.print(str);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	@RequestMapping("inquireDelete")
	   public @ResponseBody void inquireDelete(Integer inquireNum) {
		System.out.println(inquireNum);
	      inquireRepository.inquireDelete(inquireNum);
	   }
	@GetMapping("inquireUpdate")
	public String inquireUpdate(Integer inquireNum, Model model) {
		List<InquireDTO> list = inquireRepository.inquireList(null, inquireNum);
		model.addAttribute("list", list);
		return "thymeleaf/inquire/inquireUpdate";
	}
	@PostMapping("inquireUpdate")
	@ResponseBody
	public void inquireUpdate(InquireDTO inquireDTO, HttpServletResponse response) {
		inquireRepository.inquireUpdate(inquireDTO);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			String str = "<script>"
					+ "opener.parent.inquire();"
					+ "window.self.close();"
					+ "</script>";
			out.print(str);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("goodsQuestion")
	   public String goodsQuestion(Model model) {
	      List<InquireDTO> list = inquireRepository.inquireList(null, null);
	      model.addAttribute("list", list);
	      return "thymeleaf/inquire/goodsQuestion";
	   }
	@GetMapping("inquireAnswer")
	public String inquireAnswer(Integer inquireNum, Model model) {
		List<InquireDTO> list = inquireRepository.inquireList(null, inquireNum);
		model.addAttribute("list", list);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/inquire/inquireAnswer";
	}
	@Autowired
	GoodsMapper goodsMapper;
	@PostMapping("inquireAnswer")
	public String inquireAnswer(InquireDTO dto, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empNum = goodsMapper.empNumSelect(auth.getUserId());
		dto.setEmpNum(empNum);
		inquireRepository.inquireAnswerUpdate(dto);
	    return "redirect:goodsQuestion";
	}
	
}
