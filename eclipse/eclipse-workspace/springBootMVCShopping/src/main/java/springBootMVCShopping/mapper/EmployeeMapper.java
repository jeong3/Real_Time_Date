package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.EmpDTO;
import springBootMVCShopping.domain.StartEndPageDTO;

@Mapper
public interface EmployeeMapper {

	void empInsert(EmpDTO dto);

	List<EmpDTO> empSelectList(StartEndPageDTO sepDTO);

	EmpDTO empSelectOne(String empNum);

	void empUpdate(EmpDTO dto);

	void empDelete(String[] empNum);

	Integer empCount();

}
