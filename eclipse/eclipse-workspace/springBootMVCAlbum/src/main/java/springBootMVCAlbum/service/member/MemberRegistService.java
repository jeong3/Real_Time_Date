package springBootMVCAlbum.service.member;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCAlbum.command.MemberCommand;
import springBootMVCAlbum.domain.MemberDTO;
import springBootMVCAlbum.mapper.MemberMapper;

@Service
public class MemberRegistService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		BeanUtils.copyProperties(memberCommand, dto);
		memberMapper.memberInsert(dto);
	}

}
