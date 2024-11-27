package springBootMVCAlbum;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import springBootMVCAlbum.command.LoginCommand;

@Controller
@SpringBootApplication
public class SpringBootMvcAlbumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcAlbumApplication.class, args);
	}
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		return "thymeleaf/index";
	}
	
}
