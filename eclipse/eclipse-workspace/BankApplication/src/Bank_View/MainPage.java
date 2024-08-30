package Bank_View;

import java.util.Scanner;

import Bank.Request;

public class MainPage {
	Scanner scanner = new Scanner(System.in);
	Request request = new Request();
	public Request view() {
		System.out.println("------------------------------------------");
		System.out.println("1.계좌생성 | 2.계좌목록 | 3.입금 | 4.출금 | 5.종료");
		System.out.println("------------------------------------------");
		System.out.print("선택 > ");
		int num = Integer.parseInt(scanner.nextLine());
		request.setPageNum(num);
		return request;
	}
}
