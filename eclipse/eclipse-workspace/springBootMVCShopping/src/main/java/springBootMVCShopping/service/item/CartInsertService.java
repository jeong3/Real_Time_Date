package springBootMVCShopping.service.item;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.CartCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.CartDTO;
import springBootMVCShopping.mapper.CartMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class CartInsertService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CartMapper cartMapper;
	public String execute(CartCommand cartCommand, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = null;
		memberNum = memberMapper.memberNumSelect(auth.getUserId());
		
		if(memberNum != null) {
			CartDTO dto = new CartDTO();
			dto.setCartQty(cartCommand.getQty());
			dto.setGoodsNum(cartCommand.getGoodsNum());
			dto.setMemberNum(memberNum);
			cartMapper.cartMerge(dto);
			return "200";
		}else {
			return "900";
		}
		
	}
}
