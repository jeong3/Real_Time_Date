package springBootMVCShopping.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.mapper.GoodsMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class WishListService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberId = auth.getUserId();
		String memberNum = memberMapper.memberNumSelect(memberId);
		List<GoodsDTO> list = goodsMapper.wishSelectAll(memberNum);
		model.addAttribute("list", list);
		
		
		
	}
	

}
