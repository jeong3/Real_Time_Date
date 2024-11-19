package springBootMVCShopping.command;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GoodsCommand {
	String goodsNum;
	@NotEmpty(message = "이름을 입력해주세요")
	String goodsName;
	@NotNull(message = "가격을 입력해주세요.")
	Integer goodsPrice;
	@NotEmpty(message = "설명을 입력해주세요")
	String goodsContents;
	Integer visitCount;
	MultipartFile goodsMainImage;
	String goodsMainStoreImage;
	MultipartFile goodsDetailImage [];
	String goodsDetailStoreImage;
	String empNum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date goodsRegist;
	String updateEmpNum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date goodsUpdateDate;
}
