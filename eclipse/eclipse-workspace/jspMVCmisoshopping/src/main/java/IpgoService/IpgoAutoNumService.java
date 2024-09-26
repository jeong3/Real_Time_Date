package IpgoService;

import javax.servlet.http.HttpServletRequest;

import model.IpgoDAO;

public class IpgoAutoNumService {

	public void execute(HttpServletRequest request) {
		IpgoDAO dao = new IpgoDAO();
		String ipgoNum = dao.AutoIpgoNum();
		request.setAttribute("ipgoNum", ipgoNum);
		
	}

}
