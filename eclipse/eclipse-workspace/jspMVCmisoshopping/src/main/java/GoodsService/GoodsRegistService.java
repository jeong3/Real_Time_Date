package GoodsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.AuthInfoDTO;
import model.EmployeeDAO;
import model.GoodsDAO;
import model.GoodsDTO;

public class GoodsRegistService {

	public void execute(HttpServletRequest request) {
		GoodsDTO dto = new GoodsDTO();
		GoodsDAO dao = new GoodsDAO();
		
		
		
		
		int fileSize = 1024*1024*100;
		String realPath = request.getServletContext().getRealPath("/goods/upload");
		System.out.println(realPath);
		try {
		
		MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, "utf-8", new DefaultFileRenamePolicy());
														 
		String storeMainImage = multi.getFilesystemName("mainImage");
		String mainImage = multi.getOriginalFileName("mainImage");
		
		String storeImage1 = multi.getFilesystemName("image1");
		String image1 = multi.getOriginalFileName("image1");
		
		String storeImage2 = multi.getFilesystemName("image2");
		String image2 = multi.getOriginalFileName("image2");
		
		String storeImage3 = multi.getFilesystemName("image3");
		String image3 = multi.getOriginalFileName("image3");
		
		String goodsDetailStoreImage = storeImage1 + "`"+ storeImage2 + "`" + storeImage3;
		String goodsDetailImage = image1 + "`" + image2 + "`" + image3;
		
		
		
		EmployeeDAO dao1 = new EmployeeDAO();
		String empNum = multi.getParameter("userNum");
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empId = auth.getUserId();
		empNum = dao1.empNumSelect(empId);
		dto.setGoodsNum(multi.getParameter("goodsNum"));
		dto.setGoodsName(multi.getParameter("goodsName"));
		dto.setGoodsContents(multi.getParameter("goodsContents"));
		dto.setEmpNum(empNum);
		dto.setGoodsPrice(Integer.parseInt(multi.getParameter("goodsPrice")));
		dto.setUpdateEmpNum(empNum);
		dto.setGoodsMainImage(mainImage);
		dto.setGoodsMainStoreImage(storeMainImage);
		dto.setGoodsDetailImage(goodsDetailImage);
		dto.setGoodsDetailStoreImage(goodsDetailStoreImage);
		
		dao.GoodsRegist(dto);
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
