package UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.MemberDAO;

public class MemberDropService {

	public int execute(HttpServletRequest request) {
		String memberPw = request.getParameter("memberPw");
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		if(!memberPw.equals(auth.getUserPw())) {
			request.setAttribute("errPw", "비밀번호 틀림 ㅅㄱ");
			return 0;
		}else {
			MemberDAO dao = new MemberDAO();
			String memberNum = dao.memberNumSelect(auth.getUserId());
			dao.memberDelete(memberNum);
			return 1;
		}
		
	}

}
