package springBootMVCShopping.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.GoodsCartDTO;
import springBootMVCShopping.mapper.CartMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class CartListService {
	@Autowired
	CartMapper cartMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberId = auth.getUserId();
		String memberNum = memberMapper.memberNumSelect(memberId);
		List<GoodsCartDTO> list = cartMapper.cartSelectAll(memberNum);
		model.addAttribute("list", list);
		//auth가 null일 때를 예외처리 try~catch로 두고 세션이 없을 때와
		//세션이 직원일 때를 나누는 편이 좋다.
		// 200 , 000 , 900 으로 일반적으로 나눈다 정상, 세션이 null일때, 세션이 회원이 아닐때
		Integer totalPrice = 0;
		Integer totalQty = 0;
		for(GoodsCartDTO dto : list) {
			totalPrice += dto.getGoodsDTO().getGoodsPrice() * dto.getCartDTO().getCartQty();
			totalQty += dto.getCartDTO().getCartQty();
		}
		model.addAttribute("totPri", totalPrice);
		model.addAttribute("totQty", totalQty);
		
	}
	

}
