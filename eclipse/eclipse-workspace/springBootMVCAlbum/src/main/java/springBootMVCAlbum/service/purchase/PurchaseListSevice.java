package springBootMVCAlbum.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCAlbum.domain.OrderListDTO;
import springBootMVCAlbum.mapper.PurchaseSelectMapper;

@Service
public class PurchaseListSevice {
	@Autowired
	PurchaseSelectMapper purchaseMapper;
	public void execute(Model model) {
		List<OrderListDTO> list = purchaseMapper.PurchaseSelectAll();
		model.addAttribute("list", list);
	}

}
