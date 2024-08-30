package Bank_Service;

import java.util.List;

import Bank_Model.AccountDAO;
import Bank_Model.AccountDTO;

public class AccountListService {
	
	public List<AccountDTO> execute() {
		AccountDAO dao = new AccountDAO();
		List<AccountDTO> list = dao.accountAll();
		return list;
	}
}
