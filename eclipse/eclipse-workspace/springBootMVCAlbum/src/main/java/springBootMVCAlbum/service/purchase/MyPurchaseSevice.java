package springBootMVCAlbum.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.domain.OrderListDTO;
import springBootMVCAlbum.mapper.PurchaseSelectMapper;

@Service
public class MyPurchaseSevice {
	@Autowired
	PurchaseSelectMapper purchaseMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = auth.getUserNum();
		List<OrderListDTO> list = purchaseMapper.myPurchaseSelect(memberNum);
		model.addAttribute("list", list);
	}

}
