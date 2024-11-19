package springBootMVCShopping.service.item;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.CartMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class ItemCartService {
	@Autowired
	CartMapper cartMapper;
	@Autowired
	MemberMapper memberMapper;
	
	public Integer execute(HttpSession session, String goodsNum, Integer cartQty) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberId = auth.getUserId();
		String memberNum = memberMapper.memberNumSelect(memberId);
		Integer i = cartMapper.cartMerge(goodsNum, memberNum, cartQty);
		return i;
	}
	
}
