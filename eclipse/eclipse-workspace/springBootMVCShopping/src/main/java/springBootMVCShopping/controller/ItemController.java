package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.service.item.CartListService;
import springBootMVCShopping.service.item.GoodsCartDelsService;
import springBootMVCShopping.service.item.GoodsDetailViewService;
import springBootMVCShopping.service.item.WishListService;

@Controller
@RequestMapping("item")
public class ItemController {
	
	@Autowired
	CartListService cartListService;
	@Autowired
	WishListService wishListService;
	@Autowired
	GoodsCartDelsService goodsCartDelsService;
	
	@GetMapping("cartList")
	public String cartList(HttpSession session, Model model) {
		cartListService.execute(session, model);
		return "thymeleaf/item/cartList";
	}
	@GetMapping("wishList")
	public String wishList(HttpSession session, Model model) {
		wishListService.execute(session,model);
		return "thymeleaf/item/wishList";
	}
	@GetMapping("cartDel")
	public String cartDel(String goodsNums[], HttpSession session) {
		goodsCartDelsService.execute(goodsNums, session);
		return "redirect:cartList";
	}
	
}
