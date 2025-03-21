package springBootMVCAlbum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.ReviewCommand;
import springBootMVCAlbum.domain.GoodsStockDTO;
import springBootMVCAlbum.mapper.GoodsMapper;
import springBootMVCAlbum.mapper.ItemMapper;
import springBootMVCAlbum.mapper.PurchaseSelectMapper;
import springBootMVCAlbum.service.FileDelService;
import springBootMVCAlbum.service.goods.WishStatusService;
import springBootMVCAlbum.service.goods.WishUpdateService;
import springBootMVCAlbum.service.item.CartDeleteService;
import springBootMVCAlbum.service.item.CartUpdateService;
import springBootMVCAlbum.service.review.ReviewRegistService;
import springBootMVCAlbum.service.review.ReviewUpdateService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	FileDelService fileDelService;
	@Autowired
	WishUpdateService wishUpdateService;
	@Autowired
	WishStatusService wishStatusService;
	@Autowired
	CartUpdateService cartUpdateService;
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	ItemMapper itemMapper;
	@Autowired
	CartDeleteService cartDeleteService;
	@Autowired
	PurchaseSelectMapper purchaseMapper;
	@Autowired
	ReviewRegistService reviewRegistService;
	@Autowired
	ReviewUpdateService reviewUpdateService;
	
	
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
    public Integer addCart(@RequestBody Map<String, String> map, HttpSession session) {
		System.out.println(map.get("cartQty")+"|||"+map.get("goodsNum"));
		Integer cartNum = cartUpdateService.execute(map, session);
        return cartNum;  // 성공 응답
    }
	@GetMapping("/item/checkStock")
	public int checkStock(@RequestParam String goodsNum) {
	    GoodsStockDTO dto = goodsMapper.goodsStockSelectOne(goodsNum);
	    return dto.getStock();  // 해당 상품의 재고 수량을 반환
	}
	@PostMapping("/item/upQty")
	public int upQty(@RequestBody Map<String, String> map) {
		itemMapper.upQtyUpdate(map.get("goodsNum"));
		return 200;
	}
	@PostMapping("/item/downQty")
	public int downQty(@RequestBody Map<String, String> map) {
		itemMapper.downQtyUpdate(map.get("goodsNum"));
		return 200;
	}
	@PostMapping("/item/cartDelete")
	public ResponseEntity<Integer> cartDelete(@RequestBody List<String> cartNums) {
	
		Integer i = cartDeleteService.execute(cartNums);
		return ResponseEntity.ok(i);
	}
	@RequestMapping("/purchase/paymentDelete")
	public int paymentDelete(@RequestParam("purchaseNum") String purchaseNum) {
		purchaseMapper.paymentDelete(purchaseNum);
		return 200;
	}
	@RequestMapping("/purchase/deliveryRegist")
	public int deliveryRegist(@RequestBody Map<String, String> map) {
		System.out.println(map.get("purchaseNum")+"aaa"+map.get("deliveryNum"));
		purchaseMapper.deliveryInsert(map);
		return 200;
	}
	@RequestMapping("/purchase/deliveryStatusUpdate")
	public int deliveryStatusUpdate(@RequestParam("deliveryNum") String deliveryNum) {
		System.out.println(deliveryNum+"딜리버리넘");
		purchaseMapper.deliveryStatusUpdate(deliveryNum);
		return 200;
	}
	@PostMapping("/reviews/reviewRegist")
	public int reviewRegist(@RequestBody ReviewCommand reviewCommand , HttpSession session) {
	
		reviewRegistService.execute(reviewCommand, session);
		
		return 200;
	}
	@PostMapping("/reviews/reviewUpdate")
	public int reviewUpdate(@RequestBody ReviewCommand reviewCommand , HttpSession session) {
	
		reviewUpdateService.execute(reviewCommand, session);
		
		return 200;
	}
			
}
