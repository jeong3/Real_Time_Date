package springBootMVCShopping.service.goods;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springBootMVCShopping.command.GoodsCommand;
import springBootMVCShopping.domain.FileDTO;
import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.mapper.GoodsMapper;

@Service
public class GoodsUpdateService {
	@Autowired
	GoodsMapper goodsMapper;

	public void execute(GoodsCommand goodsCommand, HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsContents(goodsCommand.getGoodsContents());
		dto.setGoodsDetailStoreImage(goodsCommand.getGoodsDetailStoreImage());
		dto.setGoodsMainStoreImage(goodsCommand.getGoodsMainStoreImage());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setEmpNum(goodsCommand.getEmpNum());
		dto.setUpdateEmpNum(goodsCommand.getUpdateEmpNum());

		// 파일시스템에서 지워야함
		// 1.디렉터리 정보
		URL resource = getClass().getClassLoader().getResource("static/upload");
		String fileDir = resource.getFile();
		System.out.println(fileDir);

		if (goodsCommand.getGoodsMainImage() != null) { // 커맨드에 파일이 있다면
			// 2.파일객체 불러오기
			MultipartFile mf = goodsCommand.getGoodsMainImage();
			// 3.파일이름 가져오기
			String originFile = mf.getOriginalFilename();
			// 4.확장자 불러오기
			String extension = originFile.substring(originFile.lastIndexOf("."));
			// 5.새로운 파일명 만들기
			String storeName = UUID.randomUUID().toString().replace("-", "");
			// 6.새로운 파일명과 확장자 잇기
			String storeFileName = storeName + extension;
			// 7.파일객체 생성
			File file = new File(fileDir + "/" + storeFileName);
			// 8.파일 저장
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 9. dto에 파일이름 저장
			dto.setGoodsMainImage(originFile);
			dto.setGoodsMainStoreImage(storeFileName);
		}

		String orginalTotal = "";
		String storeTotal = "";
		// 디테일 이미지들
		if (!goodsCommand.getGoodsDetailImage()[0].getOriginalFilename().isEmpty()) {

			// 2. 파일 객체 불러오기
			for (MultipartFile mf : goodsCommand.getGoodsDetailImage()) {
				// 3.파일 이름 가져오기
				String originFile = mf.getOriginalFilename();
				// 4.확장자 불러오기
				String extension = originFile.substring(originFile.lastIndexOf("."));
				// 5.새로운 파일명 만들기
				String storeName = UUID.randomUUID().toString().replace("-", "");
				// 6.새로운 파일명과 확장자 잇기
				String storeFileName = storeName + extension;
				// 7.파일객체 생성
				File file = new File(fileDir + "/" + storeFileName);
				// 8.파일 저장
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				orginalTotal += originFile + "/";
				storeTotal += storeFileName + "/";
			}

		}
		// 세션에 있는 파일은 지우고, 새로 추가된 파일은 db에 넣어야한다
		List<FileDTO> list = (List<FileDTO>) session.getAttribute("fileList");
		GoodsDTO goodsDTO = goodsMapper.goodsSelectOne(goodsCommand.getGoodsNum());

		if (goodsDTO.getGoodsDetailImage() != null) {
			List<String> dbOrg = new ArrayList<>(Arrays.asList(goodsDTO.getGoodsDetailImage().split("[/`]")));
			List<String> dbStore = new ArrayList<>(Arrays.asList(goodsDTO.getGoodsDetailStoreImage().split("[/`]")));
		
			// 세션에 임시저장해둔(삭제버튼을 눌러둔) 파일명과 DB에 있는 파일명이 같은 파일을 DB에서 삭제
			if (list != null) {
				for (FileDTO fdto : list) {
					for (String img : dbOrg) {
						if (fdto.getOrgFile().equals(img)) {
							dbOrg.remove(fdto.getOrgFile());
							dbStore.remove(fdto.getStoreFile());
							break;
						}
					}
				}
			}

			for (String img : dbOrg)
				orginalTotal += img + "/";
			for (String img : dbOrg)
				storeTotal += img + "/";
		}
		dto.setGoodsDetailImage(orginalTotal);
		dto.setGoodsDetailStoreImage(storeTotal);
		Integer i = goodsMapper.goodsUpdate(dto);
		if (i > 0) {
			if (list != null) {
				for (FileDTO fd : list) {
					File file = new File(fileDir + "/" + fd);
					if (file.exists())
						file.delete();
				}
			}
		}
	}
}
