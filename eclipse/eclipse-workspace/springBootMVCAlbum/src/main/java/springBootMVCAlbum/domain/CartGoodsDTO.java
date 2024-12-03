package springBootMVCAlbum.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("cartGoodsDTO")
public class CartGoodsDTO {
	GoodsDTO goodsDTO;
	CartDTO cartDTO;
}
