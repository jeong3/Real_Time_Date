package springBootMVCAlbum.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.service.FileDelService;
import springBootMVCAlbum.service.goods.WishStatusService;
import springBootMVCAlbum.service.goods.WishUpdateService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	FileDelService fileDelService;
	@Autowired
	WishUpdateService wishUpdateService;
	@Autowired
	WishStatusService wishStatusService;
	//@Autowired
	//CartUpdateService cartUpdateService;
	
	@PostMapping("/file/fileDel")
	public int fileDel(String orgFile, String storeFile, HttpSession session) {
		return  fileDelService.execute(orgFile, storeFile, session);
	}
	@PostMapping("/totalPrice")
	 public Map<String, Object> calculateTotalPrice(@RequestBody Map<String, Object> data) {
        int goodsPrice = Integer.parseInt(data.get("goodsPrice").toString());
        int quantity = Integer.parseInt(data.get("quantity").toString());

        // 총 금액 계산
        int totalPrice = goodsPrice * quantity;

        // 결과 반환
        Map<String, Object> response = new HashMap<>();
        response.put("totalPrice", totalPrice);
        return response;
    }
	@GetMapping("/wish")
	public Integer wish(String goodsNum, HttpSession session){
		return wishUpdateService.execute(goodsNum, session);
	}
	@GetMapping("/wish/status")
	public Integer wishStatus(String goodsNum, HttpSession session){
		return wishStatusService.execute(goodsNum, session);
	}
	
	@PostMapping("/item/addCart")
    public String addCart(@RequestBody Map<String, String> map) {
       
       //cartUpdateService.execute(map);

        return "200";  // 성공 응답
    }
}
