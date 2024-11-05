package springBootMVCShopping.mapper;

import java.util.List;
import java.util.Map;

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
	
	List<GoodsCartDTO> cartSelectAll(
			@Param("memberNum") String memberNum
			,@Param("nums") String[] nums);

	Integer cartAddUpdate(String goodsNum, String memberNum);

	void cartMerge(CartDTO dto);

	void cartQtyDown(String goodsNum, String memberNum);

	Integer goodsNumsDelete(Map<String, Object> condition);

}
