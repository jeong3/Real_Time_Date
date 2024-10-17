package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.domain.StartEndPageDTO;

@Mapper
public interface MemberMapper {

	void memberInsert(MemberDTO dto);


	List<MemberDTO> memberSelectList(StartEndPageDTO sepDTO);


	Integer memberCount();


	MemberDTO memberSelectOne(String memberNum);


	void memberUpdate(MemberDTO dto);

}
