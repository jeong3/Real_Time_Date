package UserService;

import javax.servlet.http.HttpServletRequest;

import model.MemberDTO;
import model.UserDAO;

public class UserWriteService {

	public void execute(HttpServletRequest request) {
		MemberDTO dto = new MemberDTO();
		dto.setMemberNum(request.getParameter("memberNum"));
		dto.setMemberId(request.getParameter("memberId"));
		dto.setMemberPw(request.getParameter("memberPw"));
		dto.setMemberName(request.getParameter("memberName"));
		dto.setMemberPhone1(request.getParameter("memberPhone1"));
		dto.setMemberPhone2(request.getParameter("memberPhone2"));
		dto.setMemberAddr(request.getParameter("memberAddr"));
		dto.setMemberAddrDetail(request.getParameter("memberAddrDetail"));
		dto.setMemberPost(request.getParameter("memberPost"));
		dto.setMemberEmail(request.getParameter("memberEmail"));
		dto.setGender(request.getParameter("gender"));
		UserDAO dao = new UserDAO();
		dao.userRegist(dto);
		
	}
	
}
