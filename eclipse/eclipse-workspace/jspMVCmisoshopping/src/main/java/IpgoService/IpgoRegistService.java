package IpgoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.EmployeeDAO;
import model.IpgoDAO;
import model.IpgoDTO;

public class IpgoRegistService {

	public void execute(HttpServletRequest request) {
		IpgoDTO dto = new IpgoDTO();
		
		EmployeeDAO dao1 = new EmployeeDAO();
		String empNum = request.getParameter("userNum");
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empId = auth.getUserId();
		empNum = dao1.empNumSelect(empId);
		
		
		IpgoDAO dao = new IpgoDAO();
		
		dto.setGoodsNum(request.getParameter("goodsNum"));
		dto.setIpgoNum(request.getParameter("goodsIpgoNum"));
		dto.setIpgoQty(Integer.parseInt(request.getParameter("ipgoQty")));
		dto.setIpgoPrice(Integer.parseInt(request.getParameter("ipgoPrice")));
		dto.setEmpNum(empNum);

		Date date = null;
		String madeDate = request.getParameter("madeDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			date = sdf.parse(madeDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setMadeDate(date);
		dao.IpgoRegist(dto);
		
		
		
	}
	
}
