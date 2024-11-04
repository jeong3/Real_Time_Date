package springBootMVCShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("purchaseDTO")
public class PurchaseDTO {
	String purchaseNum;
	Date purchaseDate;
	Integer purchasePrice;
	String deliveryAddr;
	String deliveryAddrDetail;
	Integer deliveryPost;
	String deliveryPhone;
	String message;
	String purchaseStatus;
	String memberNum;
	String deliveryName;
	String purchaseName;
}
