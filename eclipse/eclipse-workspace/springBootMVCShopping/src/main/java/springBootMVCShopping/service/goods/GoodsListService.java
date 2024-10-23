package springBootMVCShopping.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.mapper.GoodsMapper;

@Service
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model) {
		List<GoodsDTO> list = goodsMapper.goodsSelectAll();
		model.addAttribute("list", list);
	}

}
