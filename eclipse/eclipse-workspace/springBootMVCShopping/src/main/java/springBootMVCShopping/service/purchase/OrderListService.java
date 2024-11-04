package springBootMVCShopping.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.PurchaseDTO;
import springBootMVCShopping.mapper.MemberMapper;
import springBootMVCShopping.mapper.PurchaseMapper;
@Service
public class OrderListService {
	@Autowired
	PurchaseMapper purchaseMapper;
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = memberMapper.memberNumSelect(auth.getUserId());
		List<PurchaseDTO> list = purchaseMapper.purchaseSelectAll(memberNum);
		model.addAttribute("list", list);
		
	}

}
