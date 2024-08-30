package D20240716;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		
		Homework_Class home = new Homework_Class();
		boolean run = true;

		Scanner sc = new Scanner(System.in);
		System.out.print("고객 수 : ");
		int ownerNum = sc.nextInt();
		Homework_Class account[] = new Homework_Class[ownerNum];

		while (run) { // run이 false일 때가지 무한루프
			System.out.println("---------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택> ");
			int menuNum = sc.nextInt();
			switch (menuNum) {
			case 1:
				System.out.print("계좌번호 : ");
				sc.nextLine();
				String id = sc.nextLine();
				System.out.print("계좌주 : ");
				String ownerName = sc.nextLine();
				System.out.print("초기 입금액 : ");
				int balance = sc.nextInt();
				account[home.num++] = new Homework_Class(id, ownerName, balance);
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			case 2:
				for (Homework_Class obj : account) { 
					//for each문으로 account 배열 내에 저장된 값 목록을 출력
					if (obj != null) 
// account 배열 내에 모두 값을 주지 않았을 때 null이 있어 오류 발생하기 때문에 null이 아닌 것을 출력
						obj.print();
				}
				break;
			case 3:
				System.out.print("계좌번호 : ");
				sc.nextLine();
				id = sc.nextLine();
				System.out.print("예금액 : ");
				int money = sc.nextInt();
				for (Homework_Class obj : account) { 
					//배열 내에서 계좌번호와 일치하는 것을 찾기 위해 for each문을 돌려야한다.
					if (obj != null) { //위와 같음
						if (id.equals(obj.getId())) {
					// 입력한 값이 obj 객체 내에서 같은 id값을 있을 때 밑의 코드를 출력한다.
							obj.setBalance(obj.getBalance() + money);
					//반환한 balance값을 입력한 money와 더해서 set에 저장한다.
						}
					}
				}
				break;
			case 4:
				System.out.print("계좌번호 : ");
				sc.nextLine();
				id = sc.nextLine();
				System.out.print("출금액 : ");
				money = sc.nextInt();
				for (Homework_Class obj : account) {
					if (obj != null) {
						if (id.equals(obj.getId())) {
							obj.setBalance(obj.getBalance() - money);
						}
					}
				}
				break;
			case 5:
				run = false;
				System.out.println("프로그램 종료");
			}

			// for(클래스명 obj: account){if(obj == null) break; obj.print();}
		}

	}

}
