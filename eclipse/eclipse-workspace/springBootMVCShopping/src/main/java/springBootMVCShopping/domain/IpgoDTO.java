package springBootMVCShopping.domain;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("ipgoDTO")
public class IpgoDTO {
	String ipgoNum;
	String goodsNum;
	Integer ipgoQty;
	Date ipgoDate;
	Timestamp madeDate;
	Integer ipgoPrice;
	String empNum;
	
}
