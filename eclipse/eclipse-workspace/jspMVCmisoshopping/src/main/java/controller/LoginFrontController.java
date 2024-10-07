package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UserService.UserLoginService;

public class LoginFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/Login.login")) {
			UserLoginService action = new UserLoginService();
			int i = action.execute(request, response);
			System.out.println("login.login");
			if(i == 1)response.sendRedirect(contextPath);
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
		} else if(command.equals("/logout.login")) {
			// 쿠키 삭제
			Cookie cookie = new Cookie("keepLogin", ""); 
			cookie.setPath("/");
			cookie.setMaxAge(0); 
			response.addCookie(cookie);
			
			HttpSession session = request.getSession();
			session.invalidate(); // 모든 세션을 삭제
			response.sendRedirect(contextPath); //request.setAttribute()의 값이 지워짐 -> requestdispatcher를 사용해야함
		} else if(command.equals("/loginCk.login")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/login1.login")) {
			UserLoginService action = new UserLoginService();
			int i = action.execute(request, response);
			if(i == 1) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html; charset=utf-8");
				out.print("<script type=\'text/javascript\'>");
				out.print("opener.document.location.reload();");
				out.print("window.self.close();");
				out.print("</script>");
				out.close();
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
