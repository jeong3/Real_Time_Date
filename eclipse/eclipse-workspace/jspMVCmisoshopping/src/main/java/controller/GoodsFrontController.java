package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GoodsService.AutoGoodsNumService;
import GoodsService.GoodsDetailService;
import GoodsService.GoodsListService;
import GoodsService.GoodsRegistService;
import GoodsService.GoodsUpdateService;
import GoodsService.goodsDeleteService;

public class GoodsFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String command = RequestURI.substring(ContextPath.length());
		if(command.equals("/goodsList.goods")) {
			GoodsListService action = new GoodsListService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsList.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/goodsWrite.goods")) {
			AutoGoodsNumService action = new AutoGoodsNumService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsRegist.goods")) {
			
			GoodsRegistService action = new GoodsRegistService();
			action.execute(request);
			response.sendRedirect("goodsList.goods");
		} else if(command.equals("/goodsDetail.goods")) {
			GoodsDetailService action = new GoodsDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsInfo.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/goodsUpdate.goods")) {
			GoodsDetailService action = new GoodsDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsModify.jsp");
			dispatcher.forward(request, response);	
		} else if(command.equals("/goodsModify.goods")) {
			GoodsUpdateService action = new GoodsUpdateService();
			action.execute(request);
			response.sendRedirect("goodsDetail.goods?goodsNum="+request.getParameter("goodsNum"));
		} else if(command.equals("/goodsDelete.goods")) {
			goodsDeleteService action = new goodsDeleteService();
			action.execute(request);
			response.sendRedirect("goodsList.goods");
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
