package UserService;

import javax.servlet.http.HttpServletRequest;

import model.AuthInfoDTO;
import model.UserDAO;

public class IdCheckService {

	public void execute(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		UserDAO dao = new UserDAO();
		AuthInfoDTO dto = dao.loginSelect(userId);
		request.setAttribute("auth", dto);
		request.setAttribute("userId", userId);
		
	}

}
