package springBootMVCAlbum.command;

import lombok.Data;

@Data
public class PurchaseCommand {
	String goodsNums;
	Integer purchasePrice;
	String purchaseName;
	String deliveryName;
	String deliveryAddr;
	String deliveryAddrDetail;
	String deliveryPost;
	String deliveryPhone;
	String message;
}
