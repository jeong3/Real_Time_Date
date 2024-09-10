package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberService.MemberAutoNumService;
import MemberService.MemberDeleteSevice;
import MemberService.MemberDetailService;
import MemberService.MemberListService;
import MemberService.MemberUpdateService;
import MemberService.MemberWriteService;

public class MemberFrontController extends HttpServlet {
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if (command.equals("/memberList.mem")) {
			MemberListService action = new MemberListService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberList.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/memberWrite.mem")) {
			MemberAutoNumService action = new MemberAutoNumService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberForm.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/memberRegist.mem")) {
			MemberWriteService action = new MemberWriteService();
			action.execute(request);
			response.sendRedirect("memberList.mem");
		} else if (command.equals("/memberDetail.mem")) {
			MemberDetailService action = new MemberDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberDetail.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/memberModify.mem")) {
			MemberDetailService action = new MemberDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberUpdate.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/memberUpdate.mem")){
			MemberUpdateService action = new MemberUpdateService();
			action.execute(request);
			response.sendRedirect("memberDetail.mem?memberNum="+request.getParameter("memberNum"));

		} else if(command.equals("/memberDelete.mem")) {
			MemberDeleteSevice action = new MemberDeleteSevice();
			action.execute(request);
			
			response.sendRedirect("memberList.mem");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}
}
