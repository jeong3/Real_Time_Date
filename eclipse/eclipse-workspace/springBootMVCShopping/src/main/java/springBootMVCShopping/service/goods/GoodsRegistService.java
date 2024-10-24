package springBootMVCShopping.service.goods;

import java.io.File;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springBootMVCShopping.command.GoodsCommand;
import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.mapper.GoodsMapper;

@Service
public class GoodsRegistService {
	@Autowired
	GoodsMapper goodsMapper;

	public void execute(GoodsCommand goodsCommand) {
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsContents(goodsCommand.getGoodsContents());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setEmpNum(goodsCommand.getEmpNum());

	////// 파일 추가
			/// 경로
			URL resource = getClass().getClassLoader().getResource("static/upload");
			System.out.println("resource : " + resource);
			String filrDir = resource.getFile();
			//String filrDir = "C:/Users/misolaptop1/eclipse-workspace/real_time_data_process_20240708/springBootMVCShopping/target/classes/static/upload";
			////////파일 관련 내용
			//  메인이미지
			MultipartFile mf = goodsCommand.getGoodsMainImage();
			String originalFile = mf.getOriginalFilename();
			/// 저장하기 위한 이름 만들기 : UUID : shfioshiof30750937skfhs
			// 확장자 : .jpg, .png : abcd.abdc.jpg
			String extension = originalFile.substring(originalFile.lastIndexOf("."));
			// 이름 
			String storeName = UUID.randomUUID().toString().replace("-", "");
			String storeFileName = storeName + extension;
			// 파일 생성
			File file = new File(filrDir + "/" + storeFileName);
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			/// dto에저장
			dto.setGoodsMainImage(originalFile);
			dto.setGoodsMainStoreImage(storeFileName);
			////
			if(!goodsCommand.getGoodsDetailImage()[0].getOriginalFilename().isEmpty()) {
				String originalTotal = ""; 
				String storeTotal = "";
				for(MultipartFile mpf : goodsCommand.getGoodsDetailImage()) {
					originalFile = mpf.getOriginalFilename();//오류
					extension = originalFile.substring(originalFile.lastIndexOf("."));
					storeName = UUID.randomUUID().toString().replace("-", "");
					storeFileName = storeName + extension;
					file = new File(filrDir + "/" + storeFileName);
					try {
						mpf.transferTo(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
					originalTotal += originalFile + "/";
					storeTotal += storeFileName +"/";
				}
				dto.setGoodsDetailImage(originalTotal);
				dto.setGoodsDetailStoreImage(storeTotal);
			}
		goodsMapper.goodsInsert(dto);

	}

}
