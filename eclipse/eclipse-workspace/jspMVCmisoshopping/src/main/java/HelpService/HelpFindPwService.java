package HelpService;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import model.AuthInfoDTO;
import model.HelpDAO;

public class HelpFindPwService {

	public void execute(HttpServletRequest request) {
		HelpDAO dao = new HelpDAO();
		String userId = request.getParameter("userId");
		String userPhone = request.getParameter("userPhone");
		AuthInfoDTO dto = dao.findPwSelect(userId,userPhone);
		request.setAttribute("userPw", dto);
		
		//임시비밀번호
		String grade = dao.userSearch(userId,userPhone);
		if(grade != null) {
		String newPw = UUID.randomUUID().toString().substring(0,8); //임시번호를 가져올때 사용
		dao.userPwUpdate(userId, newPw,grade);
		request.setAttribute("userId", userId);
		request.setAttribute("userPw1", newPw);
		}
	}

}
