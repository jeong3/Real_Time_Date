package boardcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardService.BoardDeleteService;
import boardService.BoardDetailService;
import boardService.BoardListService;
import boardService.BoardUpdateService;
import boardService.BoardWriteService;

public class BoardFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/boardList.com")) {
			BoardListService action = new BoardListService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board/boardList.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/boardWrite.com")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board/boardForm.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/boardDetail.com")) {
			BoardDetailService action = new BoardDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board/boardDetail.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/boardModify.com")) {
			BoardDetailService action = new BoardDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board/boardUpdate.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/boardDelete.com")) {
			BoardDeleteService action = new BoardDeleteService();
			action.execute(request);
			response.sendRedirect("boardList.com");
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/boardWrite.com")) {
			BoardWriteService action = new BoardWriteService();
			action.execute(request);
			response.sendRedirect("boardList.com");
		} else if(command.equals("/boardModify.com")) {
			BoardUpdateService action = new BoardUpdateService();
			action.execute(request);
			response.sendRedirect("boardDetail.com?boardNum="+request.getParameter("boardNum"));
		}
		
			
	}
}
