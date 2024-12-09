package springBootMVCAlbum.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("reviewDTO")
public class ReviewDTO {
	String reviewNum;
    String goodsNum;
    String purchaseNum;
    Date reviewDate;
    String reviewContents;
    String memberId;
    Integer rating;
    String reviewSubject;

}
