package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GoodsService.GoodsListService;
import model.AuthInfoDTO;
import model.UserDAO;

public class MainFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String command = RequestURI.substring(ContextPath.length());
		if(command.equals("/")) {
			GoodsListService action = new GoodsListService();
			action.execute(request);
			//쿠키 사용
			Cookie [] cookies = request.getCookies();
			if(cookies != null && cookies.length > 0) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("storeId")) {
						request.setAttribute("sid", cookie.getValue());
					}
					if(cookie.getName().equals("keepLogin")) {
						UserDAO dao = new UserDAO();
						AuthInfoDTO auth = dao.loginSelect(cookie.getValue());
						HttpSession session = request.getSession();
						session.setAttribute("auth", auth);
					}
				}
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
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
