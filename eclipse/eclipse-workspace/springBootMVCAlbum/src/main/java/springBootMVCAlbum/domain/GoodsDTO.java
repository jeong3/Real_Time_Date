package springBootMVCAlbum.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;


import lombok.Data;

@Data
@Alias("goodsDTO")
public class GoodsDTO {
	String goodsNum;                
	String goodsName;               
	String artistName;             
	int goodsPrice;                
	String goodsContents;           
	int visitCount;                 
	String goodsMainImage;
	String goodsMainStoreImage;
	String goodsDetailImage;
	String goodsDetailStoreImage;   
	String registEmpNum;           
	Date goodsRegistDate;           
	String updateEmpNum;           
	Date goodsUpdateDate;          
	String category;  
}
