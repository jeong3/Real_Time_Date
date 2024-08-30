package D20240722;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		List<Account> account = new ArrayList<Account>();
		while (run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택 > ");
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1:
				System.out.println("-----");
				System.out.println("계좌생성");
				System.out.println("-----");
				System.out.print("계좌번호 : ");
				int accNo = Integer.parseInt(sc.nextLine());
				System.out.print("계좌주 : ");
				String owner = sc.nextLine();
				System.out.print("초기 입금액 : ");
				int money = Integer.parseInt(sc.nextLine());
				account.add(new Account(accNo, owner, money));
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			case 2:
				System.out.println("-----");
				System.out.println("계좌목록");
				System.out.println("-----");
				for(Account acc : account) {
					System.out.print(acc.getAccountNo()+"\t");
					System.out.print(acc.owner+"\t");
					System.out.println(acc.getBalance());
				}
				break;
			case 3:
				System.out.println("-----");
				System.out.println("예 금");
				System.out.println("-----");
				System.out.print("계좌번호 : ");
				accNo = Integer.parseInt(sc.nextLine());
				boolean noAccNum = true;
				for(Account acc : account) {
					if(acc.getAccountNo() == accNo){
						System.out.print("입금액 :");
						money = Integer.parseInt(sc.nextLine());
						acc.deposit(money);
						noAccNum = false;
						break;
					}
				}
				if(noAccNum == true)System.out.println("해당 계좌번호가 없습니다.");
				break;
			case 4:
				System.out.println("-----");
				System.out.println("출 금");
				System.out.println("-----");
				System.out.print("계좌번호 : ");
				accNo = Integer.parseInt(sc.nextLine());
				noAccNum = true;
				// 입력한 계좌번호와 account 리스트 안에 동일한 계좌번호가 있는 지 찾기위해 반복문 for를 사용한다.
				for(Account acc : account) { 
					if(acc.getAccountNo() == accNo){
						System.out.print("출금액 :");
						money = Integer.parseInt(sc.nextLine());
						acc.withdraw(money);
						noAccNum = false;
						break;
					}
				}
				if(noAccNum == true)System.out.println("해당 계좌번호가 없습니다.");
				
				break;
			case 5:
				run = false;
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("입력번호가 틀렸습니다.");
			}
		}

	}

}
