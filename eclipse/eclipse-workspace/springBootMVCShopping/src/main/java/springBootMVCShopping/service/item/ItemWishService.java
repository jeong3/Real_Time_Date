package springBootMVCShopping.service.item;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.GoodsStockMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class ItemWishService {
	@Autowired
	GoodsStockMapper goodsStockMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute(HttpSession session, String goodsNum) {
		
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberId = auth.getUserId();
		String memberNum = memberMapper.memberNumSelect(memberId);
		System.out.println(memberNum);
		Map<String, String> map = new HashMap<String, String>();
		map.put("goodsNum", goodsNum);
		map.put("memberNum", memberNum);
		goodsStockMapper.wishMerge(map);
		
		
	}
	
}
