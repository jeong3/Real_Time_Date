package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GoodsService.GoodsListService;
import IpgoService.IpgoAutoNumService;
import IpgoService.IpgoDetailService;
import IpgoService.IpgoListService;
import IpgoService.IpgoRegistService;
import IpgoService.IpgoUpdateService;

public class GoodsIpgoFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String command = RequestURI.substring(ContextPath.length());
		if(command.equals("/goodsIpgo.ipgo")) {
			IpgoAutoNumService action = new IpgoAutoNumService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("goodsIpgo/goodsIpgo.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/goodsItem.ipgo")) {
			GoodsListService action = new GoodsListService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("goodsIpgo/goodsList.jsp");
			dispatcher.forward(request, response);
		}  else if(command.equals("/goodsIpgoList.ipgo")) {
			IpgoListService action = new IpgoListService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("goodsIpgo/goodsIpgoList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/ipgoRegist.ipgo")) {
			IpgoRegistService action = new IpgoRegistService();
			action.execute(request);
			response.sendRedirect("goodsIpgoList.ipgo");
		}else if(command.equals("/goodsDetail.ipgo")) {
			IpgoDetailService action = new IpgoDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("goodsIpgo/goodsIpgoDetail.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/goodsIpgoUpdate.ipgo")) {
			IpgoDetailService action = new IpgoDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("goodsIpgo/goodsIpgoUpdate.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/goodsIpgoModify.ipgo")) {
			IpgoUpdateService action = new IpgoUpdateService();
			action.execute(request);
			response.sendRedirect("goodsDetail.ipgo?ipgoNum="+request.getParameter("goodsIpgoNum"));
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
