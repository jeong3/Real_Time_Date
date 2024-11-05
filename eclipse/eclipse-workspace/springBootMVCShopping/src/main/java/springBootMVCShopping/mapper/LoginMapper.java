package springBootMVCShopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.AuthInfoDTO;

@Mapper
public interface LoginMapper {

	Integer idCheckSelectOne(@Param("userId") String userId);

	Integer EmailCheckSelectOne(@Param("userEmail") String userEmail);

	AuthInfoDTO LoginSelectOne(@Param("userId") String userId);

	AuthInfoDTO loginSelect(String value);
	
}
