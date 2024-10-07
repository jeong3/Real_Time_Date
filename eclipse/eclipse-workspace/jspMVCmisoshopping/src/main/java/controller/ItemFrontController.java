package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GoodsService.GoodsDetailService;
import ItemService.CartListService;
import ItemService.CartMergeService;
import ItemService.CartQtyDownService;
import ItemService.GoodsItemService;
import ItemService.GoodsOrderService;
import ItemService.GoodsVisitCountService;
import ItemService.GoodsWishItemService;
import ItemService.INIstdpayPcReturn;
import ItemService.IniPayReqService;
import ItemService.PaymentDeleteService;
import ItemService.PurchaseListService;
import ItemService.PurchasedService;
import ItemService.cartItemsDeleteService;
import ReviewService.ReviewListService;


public class ItemFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String command = RequestURI.substring(ContextPath.length());
		if(command.equals("/detailView.item")) {
			GoodsVisitCountService count = new GoodsVisitCountService();
			count.execute(request);
			GoodsDetailService action = new GoodsDetailService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("item/detailView.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/wishItem.item")) {
			GoodsWishItemService action = new GoodsWishItemService();
			action.execute(request);
		} else if(command.equals("/cart.item")) {
			CartMergeService action = new CartMergeService();
			action.execute(request);
		} else if(command.equals("/cartList.item")) {
			CartListService action = new CartListService(request);
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("item/cartList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/cartQtyDown.item")) {
			CartQtyDownService action = new CartQtyDownService(request);
			action.execute(request);
			
		}else if(command.equals("/cartItemDel.item")) {
			cartItemsDeleteService action = new cartItemsDeleteService(request);
			action.execute(request);
			
			response.sendRedirect("cartList.item");
		} else if(command.equals("/itemBuy.item")) {
			
			GoodsItemService action = new GoodsItemService(request);
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("item/goodsOrder.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/goodsOrder.item")) {
			GoodsOrderService action = new GoodsOrderService(request);
			String purchaseNum = action.execute(request);
			
			response.sendRedirect("paymentOk.item?purchaseNum="+purchaseNum);
			
			
		}else if(command.equals("/paymentOk.item")) {
			IniPayReqService action1 = new IniPayReqService();
			try {
				action1.execute(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("item/payment.jsp");
			dispatcher.forward(request, response);	
		}else if(command.equals("/purchaseList.item")) {
			PurchaseListService action = new PurchaseListService(request);
			action.execute(request);
			RequestDispatcher dispatcher 
					= request.getRequestDispatcher("item/purchaseList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/INIstdpay_pc_return.item")) {
			INIstdpayPcReturn action = new INIstdpayPcReturn();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("item/buyfinished.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/close.item")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("item/close.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/paymentDelete.item")) {
			PaymentDeleteService action = new PaymentDeleteService();
			action.execute(request);
			response.sendRedirect("purchaseList.item");
		} else if(command.equals("/purchased.item")) {
			PurchasedService action = new PurchasedService();
			action.execute(request);
			response.sendRedirect("purchaseList.item");
		} else if(command.equals("/descript.item")) {
			GoodsDetailService action = new GoodsDetailService();
			action.execute(request);
			request.setAttribute("newLine", "\n");
			RequestDispatcher dispatcher = request.getRequestDispatcher("item/descript.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/buyItem.item")) {
			CartMergeService action = new CartMergeService();
			action.execute(request);
			response.sendRedirect("itemBuy.item?prodCk="+request.getParameter("goodsNum"));
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
