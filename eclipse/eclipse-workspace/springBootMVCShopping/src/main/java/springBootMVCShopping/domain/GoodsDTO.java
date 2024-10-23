package springBootMVCShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Alias("goodsDTO")
@Data
public class GoodsDTO {
	String goodsNum;
	String goodsName;
	int goodsPrice;
	String goodsContents;
	int visitCount;
	String goodsMainImage;
	String goodsMainDetailImage;
	String goodsMainStoreImage;
	String goodsDetailStoreImage;
	Date goodsRegist;
	Date goodsUpdateDate;
	String empNum;
	String updateEmpNum;
}
