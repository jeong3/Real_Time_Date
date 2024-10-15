package springBootMVCShopping.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.domain.StartEndPageDTO;
import springBootMVCShopping.mapper.MemberMapper;
import springBootMVCShopping.service.StartEndPageService;

@Service
public class MemberListService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute( Integer page, String searchWord, Model model) {
	      // 한페이지에 몇개를 보여줄것인지?
	      Integer limit = 3;
	      StartEndPageDTO sepDTO = startEndPageService.execute(page, searchWord, limit);
	      /// ///
	      List<MemberDTO> list = memberMapper.memberSelectList(sepDTO);
	      Integer count = memberMapper.memberCount();
	      startEndPageService.execute(page, limit, count, searchWord, list, model);
	   }
	
}
