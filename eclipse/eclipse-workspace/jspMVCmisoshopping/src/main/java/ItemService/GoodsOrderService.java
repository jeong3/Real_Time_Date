package ItemService;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import Service.MemberAuthService;
import model.ItemDAO;
import model.PurchaseDTO;

public class GoodsOrderService extends MemberAuthService {

	public GoodsOrderService(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	public String execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String purchaseNum = sdf.format(new Date()); 
		
		String purchaseName = request.getParameter("purchaseName");
		String totalPaymentPrice = request.getParameter("totalPaymentPrice");
		String deliveryName = request.getParameter("deliveryName");
		String deliveryAddr = request.getParameter("deliveryAddr");
		String deliveryAddrDetail = request.getParameter("deliveryAddrDetail");
		String deliveryPost = request.getParameter("deliveryPost");
		String deliveryPhone = request.getParameter("deliveryPhone");
		String message = request.getParameter("message");
		
		PurchaseDTO dto = new PurchaseDTO();
		dto.setPurchaseNum(purchaseNum);
		dto.setPurchaseName(purchaseName);
		dto.setPurchasePrice(Long.parseLong(totalPaymentPrice));
		dto.setDeliveryName(deliveryName);
		dto.setDeliveryAddr(deliveryAddr);
		dto.setDeliveryAddrDetail(deliveryAddrDetail);
		dto.setDeliveryPost(deliveryPost);
		dto.setDeliveryPhone(deliveryPhone);
		dto.setMessage(message);
		dto.setMemberNum(memberNum);
		
		ItemDAO dao = new ItemDAO();
		dao.purchaseInsert(dto);
		
		String goodsNums [] = request.getParameter("goodsNums").split("-");
		for(String goodsNum : goodsNums) {
			dao.purchaseListInsert(purchaseNum,goodsNum,memberNum);
			dao.itemDelete(goodsNum, memberNum);
		}
		return purchaseNum;
	}

}
