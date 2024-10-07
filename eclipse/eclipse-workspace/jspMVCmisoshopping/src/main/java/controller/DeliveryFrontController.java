package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DeliveryService.DeliveryDetailService;
import DeliveryService.DeliveryModifyService;
import DeliveryService.DeliveryWriteService;
import ItemService.PurchaseListService;

public class DeliveryFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/purchaseList.deli")) {
			PurchaseListService action = new PurchaseListService(request);
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("purchase/purchaseList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/deliveryRegist.deli")) {
			DeliveryDetailService action = new DeliveryDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("purchase/deliveryRegist.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/deliveryWrite.deli")) {
			DeliveryWriteService action = new DeliveryWriteService();
			action.execute(request);
			response.sendRedirect("purchaseList.deli");
		}else if(command.equals("/deliveryModify.deli")) {
			DeliveryModifyService action = new DeliveryModifyService();
			action.execute(request);
			response.sendRedirect("purchaseList.deli");
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
