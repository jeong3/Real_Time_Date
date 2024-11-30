package springBootMVCAlbum.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCAlbum.domain.GoodsDTO;
import springBootMVCAlbum.domain.GoodsStockDTO;
import springBootMVCAlbum.mapper.GoodsMapper;

@Service
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum, Model model) {
		goodsMapper.goodsVisitUpdate(goodsNum);
		GoodsStockDTO dto = goodsMapper.goodsSelectOne(goodsNum);
		model.addAttribute("dto", dto);
	}

}
