package board1.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board1.service.BoardDeleteService;
import board1.service.BoardDetailService;
import board1.service.BoardListService;
import board1.service.BoardUpdateService;
import board1.service.BoardWriteService;

public class BoardFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/boardList.nhn")) {
			BoardListService action = new BoardListService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("board/boardList.jsp");
			dispatcher.forward(request, response);
			
		} else if(command.equals("/boardWrite.nhn")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("board/boardForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardDetail.nhn")) {
			BoardDetailService action = new BoardDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("board/boardDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardModify.nhn")) {
			BoardDetailService action = new BoardDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("board/boardUpdate.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardDelete.nhn")) {
			BoardDeleteService action = new BoardDeleteService();
			action.execute(request);
			response.sendRedirect("boardList.nhn");
		}
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//form태그에서 post방식으로 전송한 경우
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/boardWrite.nhn")) {
			BoardWriteService action = new BoardWriteService();
			action.execute(request);
			response.sendRedirect("boardList.nhn"); // sendRedirect에서 /를 쓰게되면 contextPath 앞의 /로 받아들여진다.
			
		}else if(command.equals("/boardModify.nhn")) {
			BoardUpdateService action = new BoardUpdateService();
			action.execute(request);
			response.sendRedirect("boardDetail.nhn?boardNum="+request.getParameter("boardNum"));
		}
		
		
		
		
		
		
		
		
	}
}
