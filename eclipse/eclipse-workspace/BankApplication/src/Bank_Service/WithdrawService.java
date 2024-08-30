package Bank_Service;

import Bank.Request;
import Bank_Model.AccountDAO;
import Bank_Model.AccountDTO;

public class WithdrawService {
	public void execute(Request request) {
		AccountDTO dto = new AccountDTO();
		dto.setAccountNo(request.getAccountNo());
		dto.setBalance(request.getBalance());
		AccountDAO dao = new AccountDAO();
		dao.withdrawUpdate(dto);
	}
}
