package springBootMVCAlbum.service.goods;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.GoodsCommand;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.domain.FileDTO;
import springBootMVCAlbum.domain.GoodsDTO;
import springBootMVCAlbum.mapper.GoodsMapper;

@Service
public class GoodsUpdateService {
	@Autowired
	GoodsMapper goodsMapper;

	public void execute(GoodsCommand goodsCommand, HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		BeanUtils.copyProperties(goodsCommand, dto);
		
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		dto.setUpdateEmpNum(auth.getUserNum());
		
		// 파일시스템에서 지워야함
		// 1.디렉터리 정보
		URL resource = getClass().getClassLoader().getResource("static/images");
		System.out.println(resource);
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

		String originalTotal = "";
		String storeTotal = "";
		// 디테일 이미지들
		if (!goodsCommand.getGoodsDetailImage()[0].getOriginalFilename().isEmpty()) {
			// 1. 디렉터리 정보
			// 2. 파일객체를 불러오기
			for (MultipartFile mf : goodsCommand.getGoodsDetailImage()) {
				// 3. 파일이름 가져오기 :
				String originalFile = mf.getOriginalFilename();
				// 4. 확장자 불리하기
				String extension = originalFile.substring(originalFile.lastIndexOf("."));
				// 5. 새로운 파일명 만들기
				String storeName = UUID.randomUUID().toString().replace("-", "");
				// 6. 새로운 파일명과 확장자 붙이기
				String storeFileName = storeName + extension;
				// 7. 파일객체 만들기
				File file = new File(fileDir + "/" + storeFileName);
				// 8. 파일 저장
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				originalTotal += originalFile + "/";
				storeTotal += storeFileName + "/";
			}
		}
	///// session에 있는 값은 삭제 , 넘어온 파일은 추가
			// session정보를 가져온다.
			List<FileDTO> list = (List<FileDTO>) session.getAttribute("fileList");
			// 파일의 정보를 디비로 부터 가져오기
			GoodsDTO goodsDTO = goodsMapper.goodsSelectOne(goodsCommand.getGoodsNum());
			// session에 있는 정보를 디비로부터 제거
			if (goodsDTO.getGoodsDetailImage() != null) {
				// 배열을 리스트로 받아옴
				List<String> dbOrg = new ArrayList<>(Arrays.asList(goodsDTO.getGoodsDetailImage().split("[/`]")));
				List<String> dbStore = new ArrayList<>(Arrays.asList(goodsDTO.getGoodsDetailStoreImage().split("[/`]")));
				/// session에 있는 데이터를 디비와 비교헤ㅐ서 디비에 있는데이터 삭제
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
					originalTotal += img + "/";
				for (String img : dbStore)
					storeTotal += img + "/";
			}
			dto.setGoodsDetailStoreImage(storeTotal);
			dto.setGoodsDetailImage(originalTotal);

			int i = goodsMapper.goodsUpdate(dto);
			if (i > 0) {
				if (list != null) {
					for (FileDTO fd : list) {
						File file = new File(fileDir + "/" + fd.getStoreFile());
						if (file.exists())
							file.delete();
					}
				}
			}
	}
}
