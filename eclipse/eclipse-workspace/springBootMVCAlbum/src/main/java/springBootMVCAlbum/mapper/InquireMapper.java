package springBootMVCAlbum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCAlbum.domain.InquireDTO;

@Mapper
public interface InquireMapper {

	int inquireRegist(InquireDTO dto);

	List<InquireDTO> inquireSelect();

	int inquireAnswerRegist(InquireDTO dto);

}
