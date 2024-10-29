package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.GoodsIpgoGoodsNameDTO;
import springBootMVCShopping.domain.IpgoDTO;
import springBootMVCShopping.domain.StartEndPageDTO;

@Mapper
public interface IpgoMapper {

	Integer ipgoInsert(IpgoDTO dto);

	List<IpgoDTO> ipgoSelectAll(StartEndPageDTO sepDTO);

	GoodsIpgoGoodsNameDTO ipgoSelectOne(
			@Param(value = "ipgoNum") String ipgoNum,
			@Param(value = "goodsNum") String goodsNum);

	Integer ipgoUpdate(IpgoDTO dto);

	Integer ipgoCount();

	Integer ipgoDelete(String nums);



}
