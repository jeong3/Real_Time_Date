package MemberService;

import javax.servlet.http.HttpServletRequest;

import model.MemberDAO;

public class MemberAutoNumService {

	public void execute(HttpServletRequest request) {
		MemberDAO dao = new MemberDAO();
		String num = dao.memberAutoNum();
		request.setAttribute("memberNum", num);
		
	}

}
