package springBootMVCAlbum.service.item;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.mapper.ItemMapper;

@Service
public class CartUpdateService {
	@Autowired
	ItemMapper itemMapper;
	public Integer execute(Map<String, String> map, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		map.put("memberNum", auth.getUserNum());
		itemMapper.cartUpdate(map);
		return itemMapper.cartNumSelect(map);
	}

}
