package MemberService;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfoDTO;
import model.MemberDAO;
import model.MemberDTO;

public class MemberUpdateService {

	public int execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String memberNum = request.getParameter("memberNum");
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		MemberDAO dao = new MemberDAO();
		if(memberNum == null) {
			memberNum = dao.memberNumSelect(auth.getUserId());
			System.out.println(memberNum);
		}
		
		
		MemberDTO dto = new MemberDTO();
		dto.setGender(request.getParameter("gender"));
		dto.setMemberAddr(request.getParameter("memberAddr"));
		dto.setMemberAddrDetail(request.getParameter("memberAddrDetail"));
		dto.setMemberEmail(request.getParameter("memberEmail"));
		dto.setMemberId(request.getParameter("memberId"));
		dto.setMemberName(request.getParameter("memberName"));
		dto.setMemberNum(memberNum);
		dto.setMemberPhone1(request.getParameter("memberPhone1"));
		dto.setMemberPhone2(request.getParameter("memberPhone2"));
		dto.setMemberPost(request.getParameter("memberPost"));
		dto.setMemberPw(request.getParameter("memberPw"));
		
		String birth = request.getParameter("memberBirth");
		//자바에서 문자열을 날짜로 형변환
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
		date = sdf.parse(birth);
		} catch (Exception e) {e.printStackTrace();}
		dto.setMemberBirth(date);
		
		int i = 0;
		if(auth.getUserPw().equals(request.getParameter("memberPw"))) {
			dao.MemberUpdate(dto);
			i = 1;
		}else {
			request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
			
		}return i;
		
		
	}

}
