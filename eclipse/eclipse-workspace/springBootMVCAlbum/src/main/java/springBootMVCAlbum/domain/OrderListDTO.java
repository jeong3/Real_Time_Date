package springBootMVCAlbum.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("orderListDTO")
public class OrderListDTO {
	PurchaseDTO purchaseDTO;
	PaymentDTO paymentDTO;
	List<PurchaseListGoodsDTO> purchaseListGoodsDTO;
	DeliveryDTO deliveryDTO;
}
