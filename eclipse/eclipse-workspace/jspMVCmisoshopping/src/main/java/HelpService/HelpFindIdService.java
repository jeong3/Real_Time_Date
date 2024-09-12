package HelpService;

import javax.servlet.http.HttpServletRequest;

import model.AuthInfoDTO;
import model.HelpDAO;

public class HelpFindIdService {

	public void execute(HttpServletRequest request) {
		HelpDAO dao = new HelpDAO();
		String userEmail = request.getParameter("userEmail");
		String userName = request.getParameter("userName");
		System.out.println(userName+userEmail);
		AuthInfoDTO dto = dao.findIdSelect(userName,userEmail);
		request.setAttribute("userId", dto);
	}

}
