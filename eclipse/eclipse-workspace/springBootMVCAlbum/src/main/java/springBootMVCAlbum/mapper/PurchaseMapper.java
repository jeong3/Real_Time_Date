package springBootMVCAlbum.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCAlbum.domain.CartGoodsDTO;
import springBootMVCAlbum.domain.PaymentDTO;
import springBootMVCAlbum.domain.PurchaseDTO;

@Mapper
public interface PurchaseMapper {

	List<CartGoodsDTO> CartGoodsSelect(List<String> cartNums);

	String purchaseNumSelect();

	int purchaseInsert(PurchaseDTO dto);

	int purchaseListInsert(Map<String, Object> map);

	int cartDelete(Map<String, Object> map);

	PurchaseDTO purchaseSelectOne(String purchaseNum);

	int paymentInsert(PaymentDTO dto);

}
