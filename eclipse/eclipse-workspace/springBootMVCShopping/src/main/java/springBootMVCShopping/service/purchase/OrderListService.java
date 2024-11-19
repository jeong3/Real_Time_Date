package springBootMVCShopping.service.purchase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.OrderListDTO;
import springBootMVCShopping.mapper.MemberMapper;
import springBootMVCShopping.repository.PurchaseRepository;
@Service
public class OrderListService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PurchaseRepository purchaseRepository;

	
	public void execute(HttpSession session, Model model, String purchaseNum) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = memberMapper.memberNumSelect(auth.getUserId());
		/*List<PurchaseDTO> list = purchaseMapper.orderSelectAll(memberNum);
		model.addAttribute("list", list);*/
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberNum", memberNum);
		map.put("purchaseNum", purchaseNum);
		
		List<OrderListDTO> list = purchaseRepository.orderList(map);
		model.addAttribute("list", list);
	}

}
