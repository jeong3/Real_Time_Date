package springBootMVCAlbum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import springBootMVCAlbum.domain.GoodsDTO;
import springBootMVCAlbum.domain.PurchaseListGoodsDTO;
import springBootMVCAlbum.domain.ReviewDTO;

@Mapper
public interface ReviewInquiryMapper {

	int ReviewInsert(ReviewDTO dto);

	ReviewDTO goodsNumSelect(String purchaseNum, String[] goodsNums);

	List<String> choiceGoods(String purchaseNum);

	List<GoodsDTO> goodsSelect(List<String> goodsNums);

	void ReviewUpdate(ReviewDTO dto);

	ReviewDTO ReviewSelect(@RequestParam("purchaseNum") String purchaseNum
							, @RequestParam("goodsNum") String goodsNum);

	List<ReviewDTO> reviewSelectAll(String goodsNum);

}
