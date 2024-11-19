package springBootMVCShopping.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.GoodsStockDTO;

@Mapper
public interface GoodsStockMapper {

	GoodsStockDTO goodsStockSelectOne(String goodsNum);

	Integer goodsVisitCountUpdate(String goodsNum);

	Integer wishMerge( Map<String, String> map);

	Integer wishCountSelectOne(Map<String, String> map);

	




}
