package springBootMVCAlbum.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.service.item.CartListService;

@Controller
@RequestMapping("item")
public class ItemController {
	@Autowired
	CartListService cartListService;
	@GetMapping("cartList")
	public String cartList(Model model, HttpSession session) {
		cartListService.execute(model, session);
		return "thymeleaf/item/cartList";
	}
}
