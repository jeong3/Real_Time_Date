package UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import model.AuthInfoDTO;
import model.UserDAO;

public class UserLoginService {
	public int execute(HttpServletRequest request , HttpServletResponse response) {
		int i = 0;
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		UserDAO dao = new UserDAO();
		AuthInfoDTO auth = dao.loginSelect(userId);
		HttpSession session = request.getSession();
		if(auth != null) {
			System.out.println("아이디가 존재함");
			if(userPw.equals(auth.getUserPw())) {
				System.out.println("비밀번호가 일치");
				session.setAttribute("auth", auth);
				//쿠키
				String storeId = request.getParameter("storeId"); // 1. 요청
				
				if(storeId != null && storeId.equals("store")) {
					//2. 쿠키생성
					Cookie cookie = new Cookie("storeId", userId); 
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30); 
					//3. 웹브라우저로 전달
					response.addCookie(cookie);
				}else {
					// 쿠키 삭제
					Cookie cookie = new Cookie("storeId", ""); 
					cookie.setPath("/");
					cookie.setMaxAge(0); 
					// 웹브라우저로 전달
					response.addCookie(cookie);
				}
				String keepLogin = request.getParameter("keepLogin");
				if(keepLogin != null && keepLogin.equals("on")) {
					//2. 쿠키생성
					Cookie cookie = new Cookie("keepLogin", userId); 
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					//3. 웹브라우저로 전달
					response.addCookie(cookie);
				}
				
				i = 1;
			} else {
				System.out.println("비밀번호가 다릅니다.");
				request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
			}
		} else {
			System.out.println("아이디가 존재하지 않습니다.");
			request.setAttribute("errId", "아이디가 존재하지 않습니다.");
		}
		return i;
	}

}
