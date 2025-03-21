package springBootMVCShopping.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.MemberCommand;
import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.mapper.MemberMapper;
@Service
public class MemberUpdateService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setGender(memberCommand.getGender());
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberAddrDetail(memberCommand.getMemberAddrDetail());
		dto.setMemberBirth(memberCommand.getMemberBirth());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberId(memberCommand.getMemberId().trim());
		dto.setMemberName(memberCommand.getMemberName().trim());
		dto.setMemberNum(memberCommand.getMemberNum());
		dto.setMemberPhone1(memberCommand.getMemberPhone1().trim());
		dto.setMemberPost(memberCommand.getMemberPost());
		memberMapper.memberUpdate(dto);
		
	}

}
