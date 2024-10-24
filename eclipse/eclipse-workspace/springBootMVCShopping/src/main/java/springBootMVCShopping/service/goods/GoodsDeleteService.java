package springBootMVCShopping.service.goods;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.mapper.AutoNumMapper;
import springBootMVCShopping.mapper.GoodsMapper;

@Service
public class GoodsDeleteService {
	@Autowired
	AutoNumMapper autoNumMapper;
	@Autowired
	GoodsMapper goodsMapper;

	public void execute(String[] goodsNums) {

		// 삭제할 파일의 정보를 가져옴
		List<GoodsDTO> list = goodsMapper.goodsSelectList(goodsNums);
		int i = autoNumMapper.numsDelete(goodsNums, "goods", "goods_num");

		if (i > 0) {
			URL resource = getClass().getClassLoader().getResource("static/upload");
			String fileDir = resource.getFile();

			for (GoodsDTO dto : list) {
				File file = new File(fileDir + "/" + dto.getGoodsMainStoreImage());
				if (file.exists())
					file.delete();
				if (dto.getGoodsDetailImage() != null) {
					for (String fileName : dto.getGoodsDetailStoreImage().split("/")) {
						file = new File(fileDir + "/" + fileName);
						if (file.exists())
							file.delete();
					}
				}
			}
		}

	}

}
