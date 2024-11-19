package springBootMVCShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("inquireDTO")
@Data
public class InquireDTO {
		 Integer inquireNum;
	     String memberNum;
	     String goodsNum;
	     String inquireSubject;
	     String inquireContents;
	     String inquireKind;
	     Date inquireDate;
	     String inquireAnswer;
	     Date inquireAnswerDate;
	     String empNum;
	     String memberId;
	     String goodsName;
}
