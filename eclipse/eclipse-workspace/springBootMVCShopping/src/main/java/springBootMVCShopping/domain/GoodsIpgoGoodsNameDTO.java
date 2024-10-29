package springBootMVCShopping.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("goodsIpgoGoodsNameDTO")
public class GoodsIpgoGoodsNameDTO {
	String goodsName;
	IpgoDTO ipgoDTO;
}
