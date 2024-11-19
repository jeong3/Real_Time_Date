package springBootMVCShopping.service.item;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.GoodsStockDTO;
import springBootMVCShopping.mapper.GoodsStockMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class GoodsDetailViewService {
	@Autowired
	GoodsStockMapper goodsStockMapper;
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(String goodsNum, Model model, HttpServletResponse response, HttpSession session, boolean visit) {
		GoodsStockDTO dto = goodsStockMapper.goodsStockSelectOne(goodsNum);
		
		if(visit == true) {
			goodsStockMapper.goodsVisitCountUpdate(goodsNum);
		}
		model.addAttribute("dto", dto);
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		if(auth != null) {
			String memberNum = memberMapper.memberNumSelect(auth.getUserId());
			if(memberNum != null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("goodsNum", goodsNum);
				map.put("memberNum", memberNum);
				Integer i = goodsStockMapper.wishCountSelectOne(map);
				model.addAttribute("wish", i);
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(mapper.writeValueAsString(dto));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
