package springBootMVCShopping.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.CartCommand;
import springBootMVCShopping.service.EmailCheckService;
import springBootMVCShopping.service.FileDelService;
import springBootMVCShopping.service.item.CartInsertService;
import springBootMVCShopping.service.item.CartQtyDownService;
import springBootMVCShopping.service.item.ItemCartService;
import springBootMVCShopping.service.item.ItemWishService;

@RestController // spring-boot방식
public class CheckRestController {
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	FileDelService fileDelService;
	@Autowired
	ItemWishService itemWishService;
	@Autowired
	ItemCartService itemCartService;
	@Autowired
	CartInsertService cartInsertService;
	@Autowired
	CartQtyDownService cartQtyDownService;
	
	@PostMapping("/checkRest/userEmailCheck")
	public Integer emailCheck(String userEmail) {
		return emailCheckService.execute(userEmail);
	}

	@GetMapping("userConfirm")
	public String userConfirm(String chk) {
		Integer i = emailCheckService.update(chk);
		if (i == null) {
			return "이메일이 존재하지 않습니다.";
		} else {
			if (i == 1) {
				return "인증되었습니다";
			} else {
				return "이미 인증되어 있습니다";
			}
		}
	}
	@RequestMapping("/file/fileDel")
	public int fileDel(String orgFile, String storeFile, HttpSession session) {
		return  fileDelService.execute(orgFile, storeFile, session);
	}
	@PostMapping("/item/itemWish")
	public void wish(@RequestBody Map<String, Object> map, HttpSession session ) {
		System.out.println("/item/itemWish  : " + map.get("goodsNum"));
		itemWishService.execute(session,  map.get("goodsNum").toString());
	}
	@PostMapping("/item/itemCart")
	public Integer cart(HttpSession session , String goodsNum, Integer cartQty) {
		Integer i = itemCartService.execute(session, goodsNum, cartQty);
		return i;
	}
	@RequestMapping("/item/cartAdd")
	public String cartAdd(@RequestBody CartCommand cartCommand
			, HttpSession session) {
		System.out.println(cartCommand.getGoodsNum());
		return cartInsertService.execute(cartCommand, session);
	}
	@GetMapping("/item/cartQtyDown")
	public void cartQtyDown(String goodsNum, HttpSession session )  {
		cartQtyDownService.execute(goodsNum, session);
	}
	
}
