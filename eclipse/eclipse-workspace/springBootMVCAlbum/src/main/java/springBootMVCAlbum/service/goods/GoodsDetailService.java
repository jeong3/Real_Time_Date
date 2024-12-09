package springBootMVCAlbum.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCAlbum.domain.GoodsDTO;
import springBootMVCAlbum.domain.GoodsStockDTO;
import springBootMVCAlbum.domain.ReviewDTO;
import springBootMVCAlbum.mapper.GoodsMapper;
import springBootMVCAlbum.mapper.ReviewInquiryMapper;

@Service
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	ReviewInquiryMapper reviewMapper;
	public void execute(String goodsNum, Model model) {
		goodsMapper.goodsVisitUpdate(goodsNum);
		GoodsStockDTO dto = goodsMapper.goodsStockSelectOne(goodsNum);
		model.addAttribute("dto", dto);
		
		List<ReviewDTO> reviewList = reviewMapper.reviewSelectAll(goodsNum);
		model.addAttribute("reviewList", reviewList);
		
		List<GoodsDTO> goodsList = goodsMapper.goodsCategorySelectAll(dto.getGoodsDTO().getCategory());
		model.addAttribute("goodsList", goodsList);
	}

}
