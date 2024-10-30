package springBootMVCShopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springBootMVCShopping.command.LoginCommand;
import springBootMVCShopping.service.EmailSendService;
import springBootMVCShopping.service.MainGoodsListService;
import springBootMVCShopping.service.SMSMessageService;

@Controller
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SpringBootMvcShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcShoppingApplication.class, args);
	}
	@Autowired
	MainGoodsListService mainGoodsListService;
	
	@GetMapping("/")
	public String index(LoginCommand loginCommand) {
			//@RequestParam(value = "page", required = false, defaultValue = "1") Integer page
			//,LoginCommand loginCommand, Model model) {  SSR
		//mainGoodsListService.execute(page,model);
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
