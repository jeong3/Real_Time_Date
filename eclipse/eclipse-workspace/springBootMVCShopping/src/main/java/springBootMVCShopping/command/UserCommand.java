package springBootMVCShopping.command;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserCommand {
	@NotEmpty(message = "이름을 입력해주세요")
	String userName;
	@NotEmpty(message = "아이디를 입력해주세요")
	String userId;
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
			message = "영문자와 숫자 그리고 특수문자가 포함된 8글자 이상")
	String userPw;
	@NotBlank(message = "비밀번호확인을 입력해주세요")
	String userPwCon;
	String userAddr;
	String userAddrDetail;
	String userPost;
	@NotEmpty(message = "연락처를 입력해주세요")
	@Size(min = 11, max = 13)
	String userPhone1;
	String userPhone2;
	@NotNull(message = "생년월일을 입력해주세요")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date userBirth;
	String userEmail;
	String gender;
	
	public boolean isUserPwEqualsUserPwCon() {
		return userPw.equals(userPwCon);
	}
	
	
	
	
	
}
