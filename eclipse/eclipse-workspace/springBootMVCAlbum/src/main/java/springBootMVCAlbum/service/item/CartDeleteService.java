package springBootMVCAlbum.service.item;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCAlbum.mapper.ItemMapper;

@Service
public class CartDeleteService {
	@Autowired
	ItemMapper itemMapper;
	public Integer execute(List<String> cartNums) {
		itemMapper.cartDelete(cartNums);
		return 200;
	}
	
}
