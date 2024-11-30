package springBootMVCAlbum.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.service.FileDelService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	FileDelService fileDelService;
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
}
