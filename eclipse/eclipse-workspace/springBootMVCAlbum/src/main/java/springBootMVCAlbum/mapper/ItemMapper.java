package springBootMVCAlbum.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCAlbum.domain.CartGoodsDTO;

@Mapper
public interface ItemMapper {

	Integer wishUpdate(String goodsNum, String memberNum);

	Integer wishCount(String goodsNum, String memberNum);

	int cartUpdate(Map<String, String> map);

	List<CartGoodsDTO> cartList(String memberNum);

	int upQtyUpdate(String goodsNum);

	int downQtyUpdate(String goodsNum);

	int cartDelete(List<String> cartNums);
	
}
