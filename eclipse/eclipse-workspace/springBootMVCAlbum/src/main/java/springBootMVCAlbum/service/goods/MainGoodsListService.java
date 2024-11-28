package springBootMVCAlbum.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCAlbum.domain.GoodsDTO;
import springBootMVCAlbum.mapper.GoodsMapper;



@Service
public class MainGoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(Integer page, Model model) {
		int limit = 6; // 1 ~ 6
		int startRow = ((page - 1) * limit) + 1; //1
		int endRow = startRow + limit - 1; //6
		List<GoodsDTO> list = goodsMapper.maingoodsSelectList(startRow, endRow);
		int count = goodsMapper.goodsCount("");
		int maxPage = (int)((double) count / limit + 0.95);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("list", list);
		
	}

}
