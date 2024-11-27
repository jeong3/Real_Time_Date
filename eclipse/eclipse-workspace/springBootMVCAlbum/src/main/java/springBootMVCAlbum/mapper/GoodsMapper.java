package springBootMVCAlbum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCAlbum.domain.GoodsDTO;

@Mapper
public interface GoodsMapper {
	Integer goodsInsert(GoodsDTO dto);

	List<GoodsDTO> goodsSelectAll(String category);

	GoodsDTO goodsSelectOne(String goodsNum);
	
}
