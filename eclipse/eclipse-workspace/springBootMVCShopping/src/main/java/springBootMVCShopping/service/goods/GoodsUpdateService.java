package springBootMVCShopping.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.GoodsCommand;
import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.mapper.GoodsMapper;

@Service
public class GoodsUpdateService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsCommand goodsCommand) {
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsContents(goodsCommand.getGoodsContents());
		dto.setGoodsDetailStoreImage(goodsCommand.getGoodsDetailStoreImage());
		//dto.setGoodsMainDetailImage(goodsCommand.getGoodsMainDetailImage());
		//dto.setGoodsMainImage(goodsCommand.getGoodsMainImage());
		dto.setGoodsMainStoreImage(goodsCommand.getGoodsMainStoreImage());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setEmpNum(goodsCommand.getEmpNum());
		dto.setUpdateEmpNum(goodsCommand.getUpdateEmpNum());
		goodsMapper.goodsUpdate(dto);
	}

}
