package springBootMVCAlbum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCAlbum.domain.GoodsDTO;
import springBootMVCAlbum.domain.GoodsStockDTO;

@Mapper
public interface GoodsMapper {
	Integer goodsInsert(GoodsDTO dto);

	List<GoodsDTO> goodsSelectAll(String searchWord, String category);
	
	List<GoodsDTO> goodsSearchSelectAll(String searchWord);

	GoodsDTO goodsSelectOne(String goodsNum);

	Integer goodsUpdate(GoodsDTO dto);

	int goodsDelete(String goodsNum);

	int goodsVisitUpdate(String goodsNum);

	GoodsStockDTO goodsStockSelectOne(String goodsNum);

	List<GoodsDTO> goodsCategorySelectAll(String category);

	
	
}
