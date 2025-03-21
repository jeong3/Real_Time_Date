package Bank_View;

import java.util.Scanner;

import Bank.Request;
import Bank_Model.AccountDTO;

public class AccountWithdrawView {
	Scanner scanner = new Scanner(System.in);
	public Request view(AccountDTO dto) {
		System.out.print(dto.getAccountNo() + "\t");
		System.out.print(dto.getOwner() + "\t");
		System.out.print(dto.getBalance() + "\t");
		System.out.print("출금액 : ");
		int money = Integer.parseInt(scanner.nextLine());
		Request request = new Request();
		request.setAccountNo(dto.getAccountNo());
		request.setBalance(money);
		request.setPageNum(10);
		return request;
	}
}
