package springBootMVCAlbum.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCAlbum.mapper.MemberMapper;

@Service
public class MemberDeleteService {
	@Autowired
	MemberMapper memberMapper;

	public void execute(String memberNum) {
		memberMapper.memberDelete(memberNum);
	}
	
}
