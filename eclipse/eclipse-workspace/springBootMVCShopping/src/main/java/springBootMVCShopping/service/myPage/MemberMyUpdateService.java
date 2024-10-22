package springBootMVCShopping.service.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.MemberCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.mapper.MemberInfoMapper;

@Service
public class MemberMyUpdateService {
	@Autowired
	MemberInfoMapper infoMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(MemberCommand memberCommand, HttpSession session) {
		MemberDTO dto = new MemberDTO();
		dto.setGender(memberCommand.getGender());
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberAddrDetail(memberCommand.getMemberAddrDetail());
		dto.setMemberBirth(memberCommand.getMemberBirth());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberId(memberCommand.getMemberId().trim());
		dto.setMemberName(memberCommand.getMemberName().trim());
		dto.setMemberPhone1(memberCommand.getMemberPhone1().trim());
		dto.setMemberPhone2(memberCommand.getMemberPhone2().trim());
		dto.setMemberPost(memberCommand.getMemberPost());
		dto.setMemberRegist(memberCommand.getMemberRegist());
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		if(passwordEncoder.matches(memberCommand.getMemberPw(), auth.getUserPw())) {
			Integer i = infoMapper.memberMyUpdate(dto);
		}
		
		
		
	}
	
	
}
