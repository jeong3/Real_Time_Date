package springBootMVCAlbum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCAlbum.domain.MemberDTO;

@Mapper
public interface MemberMapper {

	Integer memberInsert(MemberDTO dto);

	List<MemberDTO> memberSelectAll();

}
