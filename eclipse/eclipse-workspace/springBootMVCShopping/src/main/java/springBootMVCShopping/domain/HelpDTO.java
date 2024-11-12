package springBootMVCShopping.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("helpDTO")
public class HelpDTO {
	String userPhone;
	String userEmail;
	String userId;
	String grade;
	String userPw;
}
