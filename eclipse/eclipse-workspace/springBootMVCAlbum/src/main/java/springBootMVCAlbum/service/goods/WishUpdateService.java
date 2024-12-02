package springBootMVCAlbum.service.goods;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.mapper.ItemMapper;

@Service
public class WishUpdateService {
	@Autowired
	ItemMapper itemMapper;
	public Integer execute(String goodsNum, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = auth.getUserNum();
		itemMapper.wishUpdate(goodsNum, memberNum);
		return itemMapper.wishCount(goodsNum, memberNum);
	}

}
