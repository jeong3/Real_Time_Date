package springBootMVCShopping.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.UserCommand;
import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.mapper.UserMapper;
import springBootMVCShopping.service.EmailSendService;
import springBootMVCShopping.service.SMSMessageService;

@Service
public class UserWriteService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmailSendService emailSendService;
	@Autowired
	SMSMessageService sMSMessageService;
	
	
	public void execute(UserCommand userCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setGender(userCommand.getGender());
		dto.setMemberAddr(userCommand.getUserAddr());
		dto.setMemberAddrDetail(userCommand.getUserAddrDetail());
		dto.setMemberBirth(userCommand.getUserBirth());
		dto.setMemberEmail(userCommand.getUserEmail());
		dto.setMemberId(userCommand.getUserId());
		dto.setMemberName(userCommand.getUserName());
		dto.setMemberPhone1(userCommand.getUserPhone1());
		dto.setMemberPost(userCommand.getUserPost());
		dto.setMemberPhone2(userCommand.getUserPhone2());
		dto.setMemberPw(passwordEncoder.encode(userCommand.getUserPw()));
		int i = userMapper.userInsert(dto);
		if(i > 0) {
	         //메세지, 보내는사람, 받는사람, 제목
	         String contents = "<html><body>"
	               + dto.getMemberName() + "님 가입을 환영합니다."
	               + " 가입을 완료하시려면"
	               + " <a href='http://localhost:8080/userConfirm?chk=" +dto.getMemberEmail()+"'>여기</a>를 클릭하세요."
	               + " </body></html>";
	         String subject = "가입을 환영합니다";
	         String fromEmail = "iks5567@naver.com";
	         String toEmail = dto.getMemberEmail();
	         emailSendService.mailSend(fromEmail, toEmail, subject, contents);
	         //sMSMessageService.smsSend(dto.getMemberPhone1(), "010-7146-1970", contents);
	      }
		
	}

}
