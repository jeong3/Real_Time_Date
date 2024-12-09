package springBootMVCAlbum.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCAlbum.domain.OrderListDTO;
import springBootMVCAlbum.domain.PurchaseDTO;

@Mapper
public interface PurchaseSelectMapper {

	List<OrderListDTO> myPurchaseSelect(String memberNum);

	List<OrderListDTO> PurchaseSelectAll();

	int paymentDelete(String purchaseNum);

	List<OrderListDTO> purchaseSelectOne(String purchaseNum);

	int deliveryInsert(Map<String, String> map);

	int deliveryStatusUpdate(String deliveryNum);

}
