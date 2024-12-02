package springBootMVCAlbum.controller.item;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("item")
public class ItemController {
	@GetMapping("cartList")
	public String cartList(Model model) {
		
		return "thymeleaf/item/cartList";
	}
}
