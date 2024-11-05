package springBootMVCShopping;

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
import springBootMVCShopping.command.LoginCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.LoginMapper;
import springBootMVCShopping.service.EmailSendService;
import springBootMVCShopping.service.MainGoodsListService;
import springBootMVCShopping.service.SMSMessageService;
import springBootMVCShopping.service.login.AutoLoginService;

@Controller
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SpringBootMvcShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcShoppingApplication.class, args);
	}
	@Autowired
	MainGoodsListService mainGoodsListService;
	@Autowired
	AutoLoginService autoLoginService;
	@Autowired
	LoginMapper loginMapper;
	
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
	public ModelAndView index(int page, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		mainGoodsListService.execute(page,model);
			
		return mav;
	}
	
	@GetMapping("/mailling")
	public String mail() {
		return "thymeleaf/email";
	}
	@Autowired
	EmailSendService emailSendService;
	@PostMapping("/mailling")
	public String mail(String fromEmail, String toEmail, String subject, String contents) {
		emailSendService.mailSend(fromEmail, toEmail, subject, contents);
		return "redirect:/";
	}
	@GetMapping("/smsSend")
	public String smsSend() {
		return "thymeleaf/sms";
	}
	@Autowired
	SMSMessageService sMSMessageService;
	@PostMapping("/smsSend")
	public String smsSend(String userPhone, String message) {
		sMSMessageService.smsSend(userPhone, "010-3911-2494", message);
		return "redirect:/";
	}
}
