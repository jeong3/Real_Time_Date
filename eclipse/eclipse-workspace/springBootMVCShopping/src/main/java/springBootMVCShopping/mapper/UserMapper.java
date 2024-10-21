package springBootMVCShopping.mapper;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.MemberDTO;

@Mapper
public interface UserMapper {

	void userInsert(MemberDTO dto);
	
}
