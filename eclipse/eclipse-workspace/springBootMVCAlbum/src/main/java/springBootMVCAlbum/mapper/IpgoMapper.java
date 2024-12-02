package springBootMVCAlbum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCAlbum.domain.IpgoDTO;

@Mapper
public interface IpgoMapper {

	int ipgoInsert(IpgoDTO dto);

	List<IpgoDTO> ipgoSelectAll();

	IpgoDTO ipgoSelectOne(String ipgoNum);

	int ipgoUpdate(IpgoDTO dto);

	int ipgoDelete(String ipgoNum);

}
