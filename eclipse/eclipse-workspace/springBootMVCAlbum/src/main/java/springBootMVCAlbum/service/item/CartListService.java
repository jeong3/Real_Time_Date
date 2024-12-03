package springBootMVCAlbum.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.domain.CartGoodsDTO;
import springBootMVCAlbum.domain.GoodsStockDTO;
import springBootMVCAlbum.mapper.GoodsMapper;
import springBootMVCAlbum.mapper.ItemMapper;


@Service
public class CartListService {
	@Autowired
	ItemMapper itemMapper;
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = auth.getUserNum();
		System.out.println(memberNum);
		
		List<CartGoodsDTO> list = itemMapper.cartList(memberNum);
		Integer totalPrice = 0;
		Integer totalQty = 0;
		for(CartGoodsDTO dto : list) {
			String goodsNum = dto.getGoodsDTO().getGoodsNum();
			totalPrice += dto.getGoodsDTO().getGoodsPrice() * dto.getCartDTO().getCartQty();
			totalQty += dto.getCartDTO().getCartQty();
			
			 // 각 상품의 재고를 개별적으로 모델에 담음
		    GoodsStockDTO dto1 = goodsMapper.goodsStockSelectOne(goodsNum);
		    System.out.println("stock_" + goodsNum);
		    // 상품별로 재고 정보를 담을 때, 'stock_' + 상품번호로 구분하여 담습니다.
		    model.addAttribute("stock_"+goodsNum, dto1.getStock());
		    
		}
		
		
		model.addAttribute("totPri", totalPrice);
		model.addAttribute("totQty", totalQty);
		model.addAttribute("list", list);
		
	}

}
