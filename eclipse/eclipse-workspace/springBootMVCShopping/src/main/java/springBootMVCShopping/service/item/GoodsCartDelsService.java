package springBootMVCShopping.service.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.CartMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class GoodsCartDelsService {
	@Autowired
	CartMapper cartMapper;
	@Autowired
	MemberMapper memberMapper;
	
	public String execute(String[] goodsNums, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = memberMapper.memberNumSelect(auth.getUserId());
		List<String> cs = new ArrayList<String>();
		for(String goodsNum : goodsNums ) {
			cs.add(goodsNum);
		}
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("memberNum", memberNum);
		condition.put("goodsNums", cs);
		Integer i = cartMapper.goodsNumsDelete(condition);
		if(i > 0) return "200";
		else return "000";
	}

}
