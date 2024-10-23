package springBootMVCShopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.MemberDTO;

@Mapper
public interface UserMapper {

	Integer userInsert(MemberDTO dto);

	
	
}
