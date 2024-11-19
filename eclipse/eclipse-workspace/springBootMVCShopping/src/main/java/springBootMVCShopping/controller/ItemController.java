package springBootMVCShopping.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCShopping.command.CartCommand;
import springBootMVCShopping.service.item.CartInsertService;
import springBootMVCShopping.service.item.CartListService;
import springBootMVCShopping.service.item.GoodsCartDelsService;
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
	@Autowired
	CartInsertService cartInsertService;
	
	
	@GetMapping("buyItem")
	public String buyItem(CartCommand cartCommand, HttpSession session, HttpServletResponse response) {
		String result = cartInsertService.execute(cartCommand, session);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out;
		System.out.println(result+"result asdasd");
		if(result == "900") {
			String str = "<script>"
						+ "location.href='/corner/detailView/"+cartCommand.getGoodsNum()+"';"
					   + "alert('관리자는 구매할 수 없습니다.');"
					   +"</script>";
			try {
			out = response.getWriter();
			out.print(str);
			out.close();
			}catch(Exception e) {}
			return "";
		}else {
			return "redirect:/purchase/goodsBuy?nums="+cartCommand.getGoodsNum();
		}
		
	}

	@GetMapping("cartList")
	public String cartList(HttpSession session, Model model, CartCommand cartCommand) {
		
		cartListService.execute(session, model, cartCommand);
		return "thymeleaf/item/cartList";
	}

	@GetMapping("wishList")
	public String wishList(HttpSession session, Model model) {
		wishListService.execute(session, model);
		return "thymeleaf/item/wishList";
	}

	@GetMapping("cartDel")
	public String cartDel(String goodsNums[], HttpSession session) {
		goodsCartDelsService.execute(goodsNums, session);
		return "redirect:cartList";
	}

}
