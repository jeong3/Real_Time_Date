package springBootMVCShopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.MemberDTO;

@Mapper
public interface MemberInfoMapper {

	MemberDTO memberSelectOne(String memberId);

	Integer memberMyUpdate(MemberDTO dto);

	Integer memberPwUpdate(@Param("_newPw") String newPw
						 , @Param("_memberId") String userId);

	Integer memberDelete(@Param("_memberId") String userId);
	
}
