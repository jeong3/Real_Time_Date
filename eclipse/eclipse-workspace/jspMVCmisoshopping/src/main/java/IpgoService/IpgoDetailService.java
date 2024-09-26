package IpgoService;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import model.IpgoDAO;
import model.IpgoDTO;

public class IpgoDetailService {

	public void execute(HttpServletRequest request) {
		IpgoDAO dao = new IpgoDAO();
		String ipgoNum = request.getParameter("ipgoNum");
		IpgoDTO ipgodto = dao.IpgoSelectOne(ipgoNum);
		request.setAttribute("ipgodto", ipgodto);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm");
		String madeDate = sdf.format(ipgodto.getMadeDate());
		request.setAttribute("madeDate", madeDate);
	}

	

}
