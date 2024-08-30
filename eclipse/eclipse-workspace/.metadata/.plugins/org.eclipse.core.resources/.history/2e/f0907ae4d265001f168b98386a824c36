package Bank_View;

import java.util.Scanner;

import Bank.Request;

public class DepositView {
	Scanner scanner = new Scanner(System.in);
	public Request view() {
		System.out.println("------");
		System.out.println("입금");
		System.out.println("------");
		System.out.println("계좌번호 : ");
		int accNo = Integer.parseInt(scanner.nextLine());
		Request request = new Request();
		request.setAccountNo(accNo);
		request.setPageNum(7);
		return request;
	}
}
