package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.CartDTO;
import springBootMVCShopping.domain.GoodsCartDTO;
import springBootMVCShopping.domain.GoodsDTO;

@Mapper
public interface CartMapper {
	Integer cartMerge(
			 @Param("goodsNum") String goodsNum
			,@Param("memberNum") String memberNum
			,@Param("cartQty") Integer cartQty);

	GoodsDTO goodsSelect(String goodsNum);
	
	CartDTO cartSelect(Integer cartNum);
	
	List<GoodsCartDTO> cartSelectAll(String memberNum);

	Integer cartAddUpdate(String goodsNum, String memberNum);

	void cartMerge(CartDTO dto);

	void cartQtyDown(String goodsNum, String memberNum);

}
