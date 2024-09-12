package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
			int i = action.execute(request);
			System.out.println("login.login");
			if(i == 1)response.sendRedirect(contextPath);
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
		} else if(command.equals("/logout.login")) {
			HttpSession session = request.getSession();
			session.invalidate(); // 모든 세션을 삭제
			response.sendRedirect(contextPath); //request.setAttribute()의 값이 지워짐 -> requestdispatcher를 사용해야함
			
			
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
