package springBootMVCAlbum.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("memberDTO")
public class MemberDTO {
	String memberNum;
	String memberName;
	String memberId;
	String memberPw;
	String memberPwcon;
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	String memberPhone1;
	String memberPhone2;
	String gender;
	String memberEmail;
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	Date memberBirth;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memberRegist;
	String memberEmailConf;
}
