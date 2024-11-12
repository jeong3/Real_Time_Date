package springBootMVCShopping.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("purchaseListGoodsDTO")
public class PurchaseListGoodsDTO {
	PurchaseListDTO  purchaseListDTO;
	GoodsDTO goodsDTO;
	ReviewDTO reviewDTO;
}
