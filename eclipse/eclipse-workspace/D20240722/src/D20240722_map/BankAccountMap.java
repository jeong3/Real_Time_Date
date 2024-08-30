package D20240722_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import D20240722.Account;

public class BankAccountMap {

	public static void main(String[] args) {
		Map<Integer, Account> account = new HashMap<Integer, Account>();
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택 > ");
			String num = sc.nextLine();
			switch (num) {
			case "1": 
				System.out.println("-----");
				System.out.println("계좌생성");
				System.out.println("-----");
				System.out.print("계좌번호 : ");
				int accNo = Integer.parseInt(sc.nextLine());
				System.out.print("계좌주 : ");
				String owner = sc.nextLine();
				System.out.print("초기입금액 : ");
				int money = Integer.parseInt(sc.nextLine());
				account.put(accNo, new Account(accNo,owner,money));
				break;
			case "2":
				System.out.println("-----");
				System.out.println("계좌목록");
				System.out.println("-----");
				for(Integer key : account.keySet()) {
					Account acc = account.get(key);
					System.out.print(acc.getAccountNo()+" ");
					System.out.print(acc.getOwner()+" ");
					System.out.println(acc.getBalance()+" ");
				}
				break;
			case "3": 
				System.out.println("-----");
				System.out.println("예 금");
				System.out.println("-----");
				System.out.print("계좌번호 : ");
				accNo = Integer.parseInt(sc.nextLine());
				if(account.get(accNo) != null) {
					Account acc = account.get(accNo);
					System.out.print("입금액 : ");
					money = Integer.parseInt(sc.nextLine());
					acc.deposit(money);
				}else {
					System.out.println("해당계좌가 존재하지 않습니다.");
				}
				break;
			case "4":
				System.out.println("-----");
				System.out.println("출 금");
				System.out.println("-----");
				System.out.print("계좌번호 : ");
				accNo = Integer.parseInt(sc.nextLine());
				if(account.get(accNo) != null) {
					Account acc = account.get(accNo);
					System.out.print("출금액 : ");
					money = Integer.parseInt(sc.nextLine());
					acc.withdraw(money);
				}else {
					System.out.println("해당계좌가 존재하지 않습니다.");
				}
				break;
			case "5":
				run = false;
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("번호입력이 잘못되었습니다.");
			}
		}
	}

}
