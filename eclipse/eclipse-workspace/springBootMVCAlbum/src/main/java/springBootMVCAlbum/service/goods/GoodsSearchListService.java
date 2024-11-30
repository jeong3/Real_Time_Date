package springBootMVCAlbum.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCAlbum.domain.GoodsDTO;
import springBootMVCAlbum.mapper.GoodsMapper;

@Service
public class GoodsSearchListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String searchWord, String category, Model model) {
		System.out.println(category+"서비스");
		
		List<GoodsDTO> list = goodsMapper.goodsSelectAll(searchWord, category);
		if(searchWord == null) searchWord = "";
		
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("category", category);
		model.addAttribute("list", list);
		
	}

}
