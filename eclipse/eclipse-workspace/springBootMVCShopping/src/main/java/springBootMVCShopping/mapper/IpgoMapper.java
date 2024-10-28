package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.IpgoDTO;

@Mapper
public interface IpgoMapper {

	Integer ipgoInsert(IpgoDTO dto);

	List<IpgoDTO> ipgoSelectAll();

	IpgoDTO ipgoSelectOne(String ipgoNum);

	Integer ipgoUpdate(IpgoDTO dto);



}
