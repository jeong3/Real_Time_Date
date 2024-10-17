package springBootMVCShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("EmpDTO")
@Data
public class EmpDTO {
	String empNum;
	String empId;
	String empPw;
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
