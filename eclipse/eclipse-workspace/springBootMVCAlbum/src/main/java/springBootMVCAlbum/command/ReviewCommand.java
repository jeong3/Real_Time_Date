package springBootMVCAlbum.command;

import java.util.Date;

import lombok.Data;
@Data
public class ReviewCommand {
	    String reviewNum;
	    String goodsNum;
	    String purchaseNum;
	    Date reviewDate;
	    String reviewContents;
	    String memberId;
	    Integer rating;
	    String reviewSubject;
	

}
