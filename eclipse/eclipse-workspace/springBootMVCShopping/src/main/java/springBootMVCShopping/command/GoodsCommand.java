package springBootMVCShopping.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class GoodsCommand {
	String goodsNum;
	String goodsName;
	int goodsPrice;
	String goodsContents;
	int visitCount;
	String goodsMainImage;
	String goodsMainDetailImage;
	String goodsMainStoreImage;
	String goodsDetailStoreImage;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date goodsRegist;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date goodsUpdateDate;
	String empNum;
	String updateEmpNum;
}
