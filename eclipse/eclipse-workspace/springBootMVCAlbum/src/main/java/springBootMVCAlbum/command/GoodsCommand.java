package springBootMVCAlbum.command;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GoodsCommand {
	String goodsNum;                
	String goodsName;               
	String artistName;             
	int goodsPrice;                
	String goodsContents;           
	int visitCount;                 
	MultipartFile goodsMainImage;
	String goodsMainStoreImage;
	MultipartFile goodsDetailImage [];
	String goodsDetailStoreImage;   
	String registEmpNum;           
	Date goodsRegistDate;           
	String updateEmpNum;           
	Date goodsUpdateDate;          
	String category;                

}
