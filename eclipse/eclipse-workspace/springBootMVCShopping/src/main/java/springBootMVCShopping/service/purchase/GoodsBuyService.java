package springBootMVCShopping.service.purchase;

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
public class GoodsBuyService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CartMapper cartMapper;
	
	public void execute(String[] nums, HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = memberMapper.memberNumSelect(auth.getUserId());
		List<GoodsCartDTO> list = cartMapper.cartSelectAll(memberNum, nums);
		model.addAttribute("list", list);
		Integer sumPrice = 0; //결제금액
		Integer DeliveryCost = 3000; // 배송비
		String goodsNums = ""; //상품번호 저장
		for(GoodsCartDTO dto : list) {
			sumPrice += dto.getGoodsDTO().getGoodsPrice() * dto.getCartDTO().getCartQty();
			goodsNums += dto.getGoodsDTO().getGoodsNum()+"-";
		}
		if(sumPrice >= 30000) DeliveryCost = 0;
		
		model.addAttribute("sumPrice", sumPrice);
		model.addAttribute("DeliveryCost", DeliveryCost);
		model.addAttribute("goodsNums", goodsNums);
		
		
	}

}
