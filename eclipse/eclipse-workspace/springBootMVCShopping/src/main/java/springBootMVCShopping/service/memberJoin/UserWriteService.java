package springBootMVCShopping.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.UserCommand;
import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.mapper.UserMapper;

@Service
public class UserWriteService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
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
		userMapper.userInsert(dto);
	}

}
