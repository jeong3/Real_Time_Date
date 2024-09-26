package MemberService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.MemberDAO;
import model.MemberDTO;

public class MemberDetailService {

	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemberDAO dao = new MemberDAO();
		String memberNum = request.getParameter("memberNum");
		if(memberNum == null) {
			HttpSession session = request.getSession();
			AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
			String memberId = auth.getUserId();
			memberNum = dao.memberNumSelect(memberId);
		}
		
		MemberDTO dto = dao.memberSelectOne(memberNum);
		request.setAttribute("dto", dto);
		
	}

}
