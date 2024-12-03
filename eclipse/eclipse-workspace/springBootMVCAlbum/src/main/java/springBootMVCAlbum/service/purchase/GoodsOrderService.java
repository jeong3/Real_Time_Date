package springBootMVCAlbum.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCAlbum.domain.CartGoodsDTO;
import springBootMVCAlbum.mapper.PurchaseMapper;

@Service
public class GoodsOrderService {
	@Autowired
	PurchaseMapper purchaseMapper;
	public void execute(List<String> cartNums, Model model) {
		List<CartGoodsDTO> list = purchaseMapper.CartGoodsSelect(cartNums);
		Integer sumPrice = 0; //결제금액
		Integer DeliveryCost = 3000; // 배송비
		String goodsNums = ""; //상품번호 저장
		for(CartGoodsDTO dto : list) {
			sumPrice += dto.getGoodsDTO().getGoodsPrice() * dto.getCartDTO().getCartQty();
			goodsNums += dto.getGoodsDTO().getGoodsNum()+"-";
		}
		if(sumPrice >= 30000) DeliveryCost = 0;
		model.addAttribute("list", list);
		model.addAttribute("sumPrice", sumPrice);
		model.addAttribute("DeliveryCost", DeliveryCost);
		model.addAttribute("goodsNums", goodsNums);
		
	}

}
