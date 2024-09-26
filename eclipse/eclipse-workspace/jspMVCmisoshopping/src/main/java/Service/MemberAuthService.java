package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.MemberDAO;

public class MemberAuthService {
	protected HttpSession session;
	protected AuthInfoDTO auth;
	protected MemberDAO memDao;
	protected String memberNum;

	public MemberAuthService(HttpServletRequest request) {
		session = request.getSession();
		auth = (AuthInfoDTO) session.getAttribute("auth");
		memDao = new MemberDAO();
		memberNum = memDao.memberNumSelect(auth.getUserId());
		
	}

}
