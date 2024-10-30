package springBootMVCShopping.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.domain.StartEndPageDTO;
import springBootMVCShopping.mapper.GoodsMapper;
import springBootMVCShopping.service.StartEndPageService;

@Service
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(Integer page, String searchWord, Model model) {
		Integer limit = 3;
		
		StartEndPageDTO sepDTO = startEndPageService.execute(page, searchWord, limit);
		
		List<GoodsDTO> list = goodsMapper.goodsSelectAll(sepDTO);
		Integer count = goodsMapper.goodsCount(searchWord);
		startEndPageService.execute(page, limit, count, searchWord, list, model);
		
	}

}
