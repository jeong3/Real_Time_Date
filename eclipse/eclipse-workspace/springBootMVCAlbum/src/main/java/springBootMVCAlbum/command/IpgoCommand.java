package springBootMVCAlbum.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class IpgoCommand {
	String goodsNum;
	String ipgoNum;
	Integer ipgoQty;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date ipgoDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date madeDate;
	Integer ipgoPrice;
	String empNum;

}
