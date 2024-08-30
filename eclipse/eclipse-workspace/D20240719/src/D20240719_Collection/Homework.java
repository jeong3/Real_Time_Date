package D20240719_Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Homework {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 로또
		/*
		 * int[] lottoNum = new int[6];
		 * 
		 * for (int i = 0; i < lottoNum.length; i++) { boolean bl = true; int num =
		 * (int) (Math.random() * 45); for (int a : lottoNum) { if (lottoNum[i] == num)
		 * { i--; bl = false; break; } } if (bl == true) lottoNum[i] = num;
		 * 
		 * } for (int i : lottoNum) { System.out.print(i + " "); }
		 * 
		 */
		Homework_Class cl = new Homework_Class();
		List<Homework_Class> account = new ArrayList<Homework_Class>();
		boolean run = true;

		System.out.print("고객 수 : ");
		int ownerNum = sc.nextInt();

		while (run) { // run이 false일 때가지 무한루프
			System.out.println("---------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택> ");
			int menuNum = sc.nextInt();
			switch (menuNum) {
			case 1:
				System.out.println("-----");
				System.out.println("계좌생성");
				System.out.println("-----");
				System.out.print("계좌번호 : ");
				sc.nextLine();
				String id = sc.nextLine();
				
				System.out.print("계좌주 : ");
				String ownerName = sc.nextLine();
				
				System.out.print("초기입금액 : ");
				int balance = sc.nextInt();
				cl = new Homework_Class(id, ownerName, balance);
				account.add(cl);
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			case 2:
				System.out.println("-----");
				System.out.println("계좌목록");
				System.out.println("-----");
				cl.print();
				
			case 3 : 
				System.out.println("-----");
				System.out.println("예 금");
				System.out.println("-----");
				System.out.print("계좌번호 : ");
				id = sc.nextLine();
				for(Homework_Class i : account) {
					
				}
				System.out.print("예금액 : ");
				balance = sc.nextInt();
			}
		}

	}

}
