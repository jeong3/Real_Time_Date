package Bank_View;

import java.util.List;

import Bank_Model.AccountDTO;

public class AccountListView {
	public void view(List<AccountDTO> list) {
		System.out.println("------");
		System.out.println("계좌목록");
		System.out.println("------");
		for(AccountDTO acc : list) {
			System.out.println("계좌번호 \t 계좌주 \t 잔액 \t");
			System.out.print(acc.getAccountNo() + "\t" );
			System.out.print(acc.getOwner() + "\t" );
			System.out.print(acc.getBalance() + "\t" );
			System.out.println("");
		}
	}
}
