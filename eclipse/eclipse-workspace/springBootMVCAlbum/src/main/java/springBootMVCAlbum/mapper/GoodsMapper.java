package springBootMVCAlbum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCAlbum.domain.GoodsDTO;

@Mapper
public interface GoodsMapper {
	Integer goodsInsert(GoodsDTO dto);

	List<GoodsDTO> goodsSelectAll(String searchWord, String category);

	GoodsDTO goodsSelectOne(String goodsNum);

	Integer goodsUpdate(GoodsDTO dto);

	int goodsDelete(String goodsNum);

	List<GoodsDTO> maingoodsSelectList(int startRow, int endRow);

	int goodsCount(String string);
	
}
