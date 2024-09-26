package IpgoService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.IpgoDAO;
import model.IpgoDTO;

public class IpgoListService {

	public void execute(HttpServletRequest request) {
		IpgoDAO dao = new IpgoDAO();
		List<IpgoDTO> ipgoList = dao.IpgoSelectAll();
		request.setAttribute("ipgoList", ipgoList);
	}

}
