package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.domain.StartEndPageDTO;

@Mapper
public interface GoodsMapper {

	Integer goodsInsert(GoodsDTO dto);

	String empNumSelect(@Param("empId_") String empId);

	List<GoodsDTO> goodsSelectAll(StartEndPageDTO sepDTO);

	GoodsDTO goodsSelectOne(String goodsNum);

	Integer goodsUpdate(GoodsDTO dto);

	Integer goodsDelete (String [] goodsNum);

	Integer goodsCount(String searchWord);

	List<GoodsDTO> goodsSelectList(String[] goodsNums);

	List<GoodsDTO> MaingoodsSelectList(@Param("startRow") int startRow
			,@Param("endRow") int endRow);

	List<GoodsDTO> wishSelectAll(String memberNum);
	
}
