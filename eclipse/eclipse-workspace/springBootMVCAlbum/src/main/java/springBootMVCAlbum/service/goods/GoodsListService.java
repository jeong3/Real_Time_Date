package springBootMVCAlbum.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCAlbum.domain.GoodsDTO;
import springBootMVCAlbum.mapper.GoodsMapper;

@Service
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String searchWord, String category, Model model) {
		List<GoodsDTO> list = goodsMapper.goodsSelectAll(searchWord, category);
		if(searchWord == null) searchWord = "";
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("list", list);
		
	}

}
