package springBootMVCShopping.mapper;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.MemberDTO;

@Mapper
public interface UserMapper {

	Integer userInsert(MemberDTO dto);

	
	
}
