package springBootMVCShopping.service.ipgo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.domain.StartEndPageDTO;
import springBootMVCShopping.mapper.GoodsMapper;

@Service
public class GoodsItemService {
	@Autowired
	GoodsMapper goodsMapper;
	public Map<String, Object> execute(String searchWord, int page, Model model) {
		int limit = 3;
		int startRow = ((page - 1) * limit) + 1; // 1 4 
		int endRow = startRow + limit - 1; // 3 6 
		StartEndPageDTO sepDTO = new StartEndPageDTO(startRow, endRow, searchWord);
		int count = goodsMapper.goodsCount(searchWord);
		int maxPage = (int)((double)count / limit + 0.95);
		int limitPage = 10;
		int startPageNum = (int)((double) page / limitPage + 0.95 - 1) * limitPage + 1;
	    int endPageNum = startPageNum + limitPage - 1;
	    if(endPageNum > maxPage) endPageNum = maxPage;
	    //if(searchWord == null) searchWord="";
	    
		List<GoodsDTO> list = goodsMapper.goodsSelectAll(sepDTO);
		//model.addAttribute("list", list);
		//model.addAttribute("count", count);
		//model.addAttribute("page", page);
		//model.addAttribute("maxPage", maxPage);
		//model.addAttribute("startPageNum", startPageNum);
		//model.addAttribute("endPageNum", endPageNum);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("page", page);
		map.put("maxPage", maxPage);
		map.put("startPageNum", startPageNum);
		map.put("endPageNum", endPageNum);
		return map;
	}

}
