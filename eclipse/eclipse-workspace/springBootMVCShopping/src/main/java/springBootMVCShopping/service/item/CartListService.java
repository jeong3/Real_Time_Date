package springBootMVCShopping.service.item;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.command.CartCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.GoodsCartDTO;
import springBootMVCShopping.domain.GoodsStockDTO;
import springBootMVCShopping.mapper.CartMapper;
import springBootMVCShopping.mapper.GoodsStockMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class CartListService {
	@Autowired
	CartMapper cartMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	GoodsStockMapper goodsStockMapper;
	
	public void execute(HttpSession session, Model model, CartCommand cartCommand) {
		
		
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberId = auth.getUserId();
		String memberNum = memberMapper.memberNumSelect(memberId);
		List<GoodsCartDTO> list = cartMapper.cartSelectAll(memberNum, null);
		model.addAttribute("list", list);
		//auth가 null일 때를 예외처리 try~catch로 두고 세션이 없을 때와
		//세션이 직원일 때를 나누는 편이 좋다.
		// 200 , 000 , 900 으로 일반적으로 나눈다 정상, 세션이 null일때, 세션이 회원이 아닐때
		Integer totalPrice = 0;
		Integer totalQty = 0;
		for(GoodsCartDTO dto : list) {
			String goodsNum = dto.getGoodsDTO().getGoodsNum();
			totalPrice += dto.getGoodsDTO().getGoodsPrice() * dto.getCartDTO().getCartQty();
			totalQty += dto.getCartDTO().getCartQty();
			GoodsStockDTO dto1 = goodsStockMapper.goodsStockSelectOne(goodsNum);
			model.addAttribute("stock", dto1.getStock());
			System.out.println(dto1.getStock()+"ASdasdasd");
		}
		System.out.println(cartCommand.getGoodsNum());
		
		
		
		model.addAttribute("totPri", totalPrice);
		model.addAttribute("totQty", totalQty);
		
	}
	

}
