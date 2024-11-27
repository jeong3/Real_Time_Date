package springBootMVCAlbum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCAlbum.domain.EmployeeDTO;

@Mapper
public interface EmpMapper {
	Integer empInsert(EmployeeDTO dto);

	List<EmployeeDTO> empSelectAll();

	EmployeeDTO empSelectOne(String empNum);

	Integer empUpdate(EmployeeDTO dto);

	Integer empPwUpdate(String updatePw, String empNum);

	Integer empDelete(String empNum);
}
