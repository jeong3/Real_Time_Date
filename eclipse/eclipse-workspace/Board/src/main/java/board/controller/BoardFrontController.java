package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardListService;
import board.service.BoardWriteService;

public class BoardFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//boardWrite.nhn
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/boardWrite.nhn")) {
			                                                           //상위폴더/board파일/jsp파일
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Board/BoardForm.jsp");
			dispatcher.forward(request, response);
			
		} else if(command.equals("/boardList.nhn")) {
			
			BoardListService action = new BoardListService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Board/boardList.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/boardWrite.nhn")) {
			System.out.println("/boardWrite.nhn");
			BoardWriteService action = new BoardWriteService();
			action.execute(request);
			response.sendRedirect("boardList.nhn");
		}
		
		
		
	}
}
