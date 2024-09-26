package GoodsService;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import model.GoodsDAO;
import model.GoodsDTO;

public class goodsDeleteService {

	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.GoodsSelectOne(goodsNum);
		int i = dao.GoodsDelete(goodsNum);
		if(i > 0) {
			String realPath = request.getServletContext().getRealPath("/goods/upload");
			String mainImage = dto.getGoodsMainStoreImage();
			File file = new File(realPath+"/"+mainImage);
			if(file.exists()) file.delete();
			String images[] = dto.getGoodsDetailStoreImage().split("`");
			for(String image : images) {
				file = new File(realPath+"/"+image);
				if(file.exists()) file.delete();
			}
		}
	}

}
