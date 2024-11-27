package springBootMVCAlbum.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("authDTO")
public class AuthInfoDTO {
	String userNum;
	String userId;
	String userPw;
	String userName;
	String userEmail;
	String grade;
	String userPhone;
	
}
