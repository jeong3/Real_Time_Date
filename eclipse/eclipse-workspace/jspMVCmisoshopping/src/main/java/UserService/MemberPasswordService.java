package UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.MemberDAO;

public class MemberPasswordService {

	public int execute(HttpServletRequest request) {
		String oldPw = request.getParameter("oldPw");
		String newPw = request.getParameter("newPw");
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		int i = 0;
		if(auth.getUserPw().equals(oldPw)) {
			MemberDAO dao = new MemberDAO();
			dao.MemberPwUpdate(newPw, auth.getUserId());
			auth.setUserPw(newPw);
			i = 1;
		}else {
			request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
		}
		return i;
		
	}

}
