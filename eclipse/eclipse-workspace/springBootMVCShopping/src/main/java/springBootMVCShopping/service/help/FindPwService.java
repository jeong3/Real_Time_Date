package springBootMVCShopping.service.help;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.command.HelpCommand;
import springBootMVCShopping.domain.HelpDTO;
import springBootMVCShopping.mapper.HelpMapper;
import springBootMVCShopping.mapper.UserMapper;
import springBootMVCShopping.service.EmailSendService;
import springBootMVCShopping.service.SMSMessageService;

@Service
public class FindPwService {
	@Autowired
	HelpMapper helpMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmailSendService emailSendService;
	@Autowired
	SMSMessageService sMSMessageService;
	
	public void execute(HelpCommand helpCommand, Model model) {
		HelpDTO helpDTO = new HelpDTO();
		helpDTO.setUserId(helpCommand.getUserId());
		helpDTO.setUserPhone(helpCommand.getUserPhone());
		helpDTO = helpMapper.pwSelect(helpDTO);
		String newPw = UUID.randomUUID().toString().substring(0,8); //임시번호를 가져올때 사용
		helpDTO.setUserPw(passwordEncoder.encode(newPw));
		helpMapper.userPwUpdate(helpDTO.getUserId(), helpDTO.getUserPw(), helpDTO.getGrade());
		model.addAttribute("userPw", newPw);
		
         String contents = "<html><body>"
               + " 임시비밀번호는 "+ newPw
               + " </body></html>";
         String subject = "임시비밀번호입니다.";
         String fromEmail = "iks5567@naver.com";
         String toEmail = "iks5567@naver.com";
         emailSendService.mailSend(fromEmail, toEmail, subject, contents);
         model.addAttribute("userEmail", toEmail);
	}
}
		
		

