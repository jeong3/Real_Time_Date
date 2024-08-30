package Bank_Service;

import Bank.Request;
import Bank_Model.AccountDAO;
import Bank_Model.AccountDTO;

public class AccountService {
	public AccountDTO execute(Request request) {
		AccountDAO dao = new AccountDAO();
		AccountDTO dto = dao.accountOne(request.getAccountNo());
		return dto;
	}
}
