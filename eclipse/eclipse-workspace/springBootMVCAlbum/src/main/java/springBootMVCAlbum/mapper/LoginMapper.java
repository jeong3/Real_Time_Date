package springBootMVCAlbum.mapper;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCAlbum.domain.AuthInfoDTO;

@Mapper
public interface LoginMapper {

	AuthInfoDTO LoginSelectOne(String userId);

	Integer idCheckSelectOne(String userId);
	
}
