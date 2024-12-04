package springBootMVCAlbum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCAlbum.domain.OrderListDTO;

@Mapper
public interface PurchaseSelectMapper {

	List<OrderListDTO> myPurchaseSelect(String memberNum);

	List<OrderListDTO> PurchaseSelectAll();

}
