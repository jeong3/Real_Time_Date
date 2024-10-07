package DeliveryService;

import javax.servlet.http.HttpServletRequest;

import model.DeliveryDAO;

public class DeliveryModifyService {

	public void execute(HttpServletRequest request) {
		String purchaseNum = request.getParameter("purchaseNum");
		DeliveryDAO dao = new DeliveryDAO();
		dao.deliveryStatusUpdate(purchaseNum);
	}

}
