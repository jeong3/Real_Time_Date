package Bank_Service;

import Bank.Request;
import Bank_Model.AccountDAO;
import Bank_Model.AccountDTO;

//pageController 
public class AccountWriteService { 
	
	public void execute(Request request) { //피호출메서드
		AccountDTO dto = new AccountDTO();
		dto.setAccountNo(request.getAccountNo());
		dto.setOwner(request.getOwner());
		dto.setBalance(request.getBalance());
		AccountDAO dao = new AccountDAO();
		dao.accountInsert(dto);
		System.out.println("계좌가 개설되었습니다.");
		
	}
}
