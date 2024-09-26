package GoodsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.EmployeeDAO;
import model.GoodsDAO;
import model.GoodsDTO;

public class GoodsUpdateService {

	public void execute(HttpServletRequest request) {
		GoodsDTO dto = new GoodsDTO();
		GoodsDAO dao = new GoodsDAO();
		
		EmployeeDAO dao1 = new EmployeeDAO();
		String updateEmpNum = request.getParameter("userNum");
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empId = auth.getUserId();
		updateEmpNum = dao1.empNumSelect(empId);
		
		dto.setGoodsNum(request.getParameter("goodsNum"));
		dto.setGoodsName(request.getParameter("goodsName"));
		dto.setGoodsPrice(Integer.parseInt(request.getParameter("goodsPrice")));
		dto.setGoodsContents(request.getParameter("goodsContents"));
		dto.setVisitCount(Integer.parseInt(request.getParameter("visitCount")));
		dto.setEmpNum(request.getParameter("empNum"));
		dto.setUpdateEmpNum(updateEmpNum);
		String goodsRegist = request.getParameter("goodsRegist");
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		
		try {
			date = sdf.parse(goodsRegist);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setGoodsRegist(date);
		dao.GoodsUpdate(dto);
		
		
	}

}
