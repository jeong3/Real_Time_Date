package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserService.IdCheckService;
import UserService.UserWriteService;

public class UserFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/userAgree.nhn")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("user/userAgree.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/userWrite.nhn")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("user/userForm.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/userRegist.nhn")) {
			UserWriteService action = new UserWriteService();
			action.execute(request);
			response.sendRedirect(request.getContextPath());
		} else if(command.equals("/idCheck.nhn")) {
			IdCheckService action = new IdCheckService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user/idCheck.jsp");
			dispatcher.forward(request, response);
		} 
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
}
