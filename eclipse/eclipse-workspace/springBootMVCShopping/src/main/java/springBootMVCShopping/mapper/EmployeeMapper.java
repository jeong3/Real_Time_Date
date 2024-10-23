package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.EmployeeDTO;
import springBootMVCShopping.domain.StartEndPageDTO;

@Mapper
public interface EmployeeMapper {

	void empInsert(EmployeeDTO dto);

	List<EmployeeDTO> empSelectList(StartEndPageDTO sepDTO);

	EmployeeDTO empSelectOne(String empNum);

	void empUpdate(EmployeeDTO dto);

	void empDelete(String[] empNum);

	Integer empCount();

}
