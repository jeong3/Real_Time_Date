package springBootMVCAlbum.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("cartDTO")
public class CartDTO {
	String memberNum; // MEMBER_NUM
	String goodsNum;  // GOODS_NUM
	Date cartDate;    // CART_DATE
	int cartQty;      // CART_QTY
	int cartNum;      // CART_NUM

}
