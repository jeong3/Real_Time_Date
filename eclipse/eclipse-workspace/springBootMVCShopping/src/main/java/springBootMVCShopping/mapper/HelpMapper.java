package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.HelpDTO;

@Mapper
public interface HelpMapper {

	HelpDTO idSelect(HelpDTO dto);

	HelpDTO pwSelect(HelpDTO dto);

	Integer userPwUpdate(String userId, String newPw, String grade);
	
}
