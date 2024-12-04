package springBootMVCAlbum.service.purchase;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.PurchaseCommand;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.domain.PurchaseDTO;
import springBootMVCAlbum.mapper.ItemMapper;
import springBootMVCAlbum.mapper.PurchaseMapper;

@Service
public class GoodsOrderRegistService {
	@Autowired
	PurchaseMapper purchaseMapper;
	@Autowired
	ItemMapper itemMapper;
	
	public String execute(PurchaseCommand purchaseCommand, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = auth.getUserNum();
		
		String purchaseNum = purchaseMapper.purchaseNumSelect();
		
		PurchaseDTO dto = new PurchaseDTO();
		BeanUtils.copyProperties(purchaseCommand, dto);
		dto.setPurchaseNum(purchaseNum);
		dto.setMemberNum(memberNum);
		purchaseMapper.purchaseInsert(dto);
		
		String goodsNums [] = purchaseCommand.getGoodsNums().split("-");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchaseNum", purchaseNum);
		map.put("memberNum", memberNum);
		map.put("goodsNums", goodsNums);
		purchaseMapper.purchaseListInsert(map);
		//구매리스트에 넣은 제품을 장바구니에서 삭제
		purchaseMapper.cartDelete(map);
		
		
		return purchaseNum;
	}

}
