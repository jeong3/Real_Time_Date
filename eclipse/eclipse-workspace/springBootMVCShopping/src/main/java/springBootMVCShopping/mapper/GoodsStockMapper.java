package springBootMVCShopping.mapper;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.GoodsStockDTO;

@Mapper
public interface GoodsStockMapper {

	GoodsStockDTO goodsStockSelectOne(String goodsNum);

}
