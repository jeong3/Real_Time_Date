package springBootMVCShopping.command;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmployeeCommand {
	String empNum;
	@NotEmpty(message = "아이디를 입력해주세요")
	String empId;
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
			message = "영문자와 숫자 그리고 특수문자가 포함된 8글자 이상")
	String empPw;
	@NotEmpty(message = "비밀번호를 확인해주세요")
	String empPwCon;
	@NotEmpty(message = "이름을 입력해주세요")
	String empName;
	@NotEmpty(message = "주소를 입력해주세요")
	String empAddr;
	String empAddrDetail;
	String empPost;
	@NotEmpty(message = "연락처를 입력해주세요")
	@Size(min = 11, max = 13)
	String empPhone;
	@NotEmpty(message = "주민등록번호를 입력해주세요")
	String empJumin;
	@NotEmpty(message = "이메일를 입력해주세요")
	String empEmail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date empHireDate;
	String empImage;
	
	public boolean isEmpPwEqualEmpPwCon() {
		return empPw.equals(empPwCon);
	}
	
	
	
}
