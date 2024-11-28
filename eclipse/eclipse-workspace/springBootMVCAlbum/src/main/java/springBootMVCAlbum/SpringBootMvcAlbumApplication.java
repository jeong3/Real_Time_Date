package springBootMVCAlbum;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.LoginCommand;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.mapper.LoginMapper;
import springBootMVCAlbum.service.goods.GoodsListService;
import springBootMVCAlbum.service.goods.MainGoodsListService;
import springBootMVCAlbum.service.login.AutoLoginService;

@Controller
@SpringBootApplication
public class SpringBootMvcAlbumApplication {

	@Autowired
	AutoLoginService autoLoginService;
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	GoodsListService goodsListService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcAlbumApplication.class, args);
	}
	@GetMapping("/")
	public String index(LoginCommand loginCommand, Model model , HttpServletRequest request) {
			//@RequestParam(value = "page", required = false, defaultValue = "1") Integer page
			//,LoginCommand loginCommand, Model model) {  SSR
		//mainGoodsListService.execute(page,model);
		//쿠키 사용
		Cookie [] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("userId")) {
					AuthInfoDTO auth = loginMapper.LoginSelectOne(cookie.getValue());
					loginCommand.setUserId(auth.getUserId());
					model.addAttribute("loginCommand", loginCommand);
				}
				if(cookie.getName().equals("autoLogin")) {
					AuthInfoDTO auth = loginMapper.LoginSelectOne(cookie.getValue());
					HttpSession session = request.getSession();
					session.setAttribute("auth", auth);
				}
			}
		}
		return "thymeleaf/index";
	}
	@PostMapping("/")
	public ModelAndView index(String searchWord, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		goodsListService.execute(searchWord, null, model);
			
		return mav;
	}
	
}
