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
public class MemberCommand {
	//String은 @NotEmpty 와 @NotBlank를 사용할 수 있다.
	String memberNum;
	@NotEmpty(message = "이름을 입력해주세요")
	String memberName;
	@NotEmpty(message = "아이디를 입력해주세요")
	String memberId;
	
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
			message = "영문자와 숫자 그리고 특수문자가 포함된 8글자 이상")
	String memberPw;
	@NotBlank(message = "비밀번호확인을 입력해주세요")
	String memberPwcon;
	@NotEmpty(message = "주소을 입력해주세요")
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	@NotEmpty(message = "연락처를 입력해주세요")
	@Size(min = 11, max = 13)
	String memberPhone1;
	String memberPhone2;
	String gender;
	@NotEmpty(message = "이메일을 입력해주세요")
	String memberEmail;
	@NotNull(message = "생년월일을 입력해주세요")
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	Date memberBirth;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	Date memberRegist;
	
	public boolean isMemberPwEqualMemberPwCon() {
		return memberPw.equals(memberPwcon);
	}
	
}
