package springBootMVCAlbum.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("ipgoDTO")
public class IpgoDTO {
	String goodsNum;
	String ipgoNum;
	Integer ipgoQty;
	Date ipgoDate;
	Date madeDate;
	Integer ipgoPrice;
	String empNum;
}
