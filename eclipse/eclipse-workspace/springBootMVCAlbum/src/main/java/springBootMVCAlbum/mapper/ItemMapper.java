package springBootMVCAlbum.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {

	Integer wishUpdate(String goodsNum, String memberNum);

	Integer wishCount(String goodsNum, String memberNum);

	void setDefindOff();
	
}
