package springBootMVCAlbum.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
