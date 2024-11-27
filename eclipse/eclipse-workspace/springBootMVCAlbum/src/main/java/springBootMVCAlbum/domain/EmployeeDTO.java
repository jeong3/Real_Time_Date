package springBootMVCAlbum.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("empDTO")
@Data
public class EmployeeDTO {
	String empNum;
	String empId;
	String empPw;
	String empPwCon;
	String empName;
	String empAddr;
	String empAddrDetail;
	String empPost;
	String empPhone;
	String empJumin;
	String empEmail;
	Date empHireDate;
	String empImage;
	
	
}
