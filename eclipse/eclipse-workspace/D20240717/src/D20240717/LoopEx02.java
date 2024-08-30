package D20240717;

import java.util.Scanner;

public class LoopEx02 {

	public static void main(String[] args) {
		// 사용자로부터 한개의 값을 입력받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요
		Scanner sc = new Scanner(System.in);
//		System.out.print("1이상의 숫자를 입력하세요 : ");
//		int num = sc.nextInt();
//		if (num < 1) {
//			System.out.print("1이상의 숫자를 입력하세요 : ");		
//		} else {
//			for (int i = 1; i <= num; i++) {
//				System.out.print(i + "\t");
//			}
//		}

		/*
		 * while(true) { System.out.print("1이상의 숫자를 입력하세요 : "); int num = sc.nextInt();
		 * if(num < 1) System.out.print(""); else { for(int i = 1; i<=num;
		 * i++)System.out.println(i + "\t"); break; } }
		 */
		/*
		 * System.out.print("원하는 숫자를 입력하세요 : "); while(true) {
		 * 
		 * int num = sc.nextInt(); if (num < 1) { System.out.print("1이상의 수를 입력하세요 :");
		 * }else { for(int i = num; i >= 1; i--)System.out.println(i + "\t"); break; } }
		 */
		/*
		 * System.out.print("1이상의 숫자를 입력하세요 : "); int num = sc.nextInt(); int sum = 0;
		 * for(int i = 1; i <= num; i++) { sum+=i;
		 * 
		 * if(i == num) { System.out.print(i+"="); }else { System.out.print(i+"+"); } }
		 * System.out.println(sum);
		 */
		// 두 개의 값을 입력 받았을 때 첫번째 값이
		/*
		 * System.out.print("첫번째 숫자를 입력하세요 : "); int num1 = sc.nextInt();
		 * System.out.print("두번째 숫자를 입력하세요 : "); int num2 = sc.nextInt(); if (num1 >
		 * num2) { for (int i = num2; i <= num1; i++) { System.out.print(i + "\t"); } }
		 * else { for (int i = num1; i <= num2; i++) { System.out.print(i + "\t"); } }
		 */
		// 사용자로 부터 입력 받은 값부터 구구단 출력
		// 단, 1미만 또는 10이상의 값을 입력하면 "1부터 9까지의 수만 입력하세요" 출력
		/*
		 * System.out.print("단을 입력하세요 : "); int dan = sc.nextInt(); if (dan < 1 || dan
		 * >= 10) { System.out.println("1부터 9까지의 수만 입력하세요"); } else { for (int i = dan;
		 * i <= 9; i++) { for (int gop = 1; gop <= 9; gop++) { System.out.println(i +
		 * " x " + gop + " = " + i * gop);
		 * 
		 * } }
		 * 
		 * }
		 */
		/*
		 * while (true) { System.out.print("단을 입력하세요 : "); int i = sc.nextInt(); if (i <
		 * 1 || i >= 10) { System.out.println("1부터 9까지의 수만 입력하세요"); } else { for (int
		 * dan = i; dan <= 9; dan++) { System.out.println("=== " + dan + "단 ==="); for
		 * (int gop = 1; gop <= 9; gop++) { System.out.println(dan + " x " + gop + " = "
		 * + dan * gop); } } break; } }
		 */
		// 두 개의 숫자를 입력 받고 하나의 연산자를 입력받아 사칙연산을 할 수 있게 코드 작성
		/*
		 * boolean run = true;
		 * 
		 * while (run) { System.out.print("첫번째 숫자를 입력하세요 : "); int num1 = sc.nextInt();
		 * System.out.print("두번째 숫자를 입력하세요 : "); int num2 = sc.nextInt();
		 * System.out.print("연산자를 입력하세요(+, -, *, /) : "); sc.nextLine(); String x =
		 * sc.nextLine();
		 * 
		 * switch (x) { case "+": run = false; System.out.println("결과 : " + (num1 +
		 * num2)); break; case "-": run = false; System.out.println("결과 : " + (num1 -
		 * num2)); break; case "*": run = false; System.out.println("결과 : " + num1 *
		 * num2); break; case "/": if(num2 == 0) {
		 * System.out.println("두번째 숫자는 0으로 나눌 수 없습니다."); }else {
		 * System.out.println("결과 : " + num1 / num2); run = false; } break; default:
		 * System.out.println("해당 연산자(+, -, *, /)에서 입력해주세요."); }
		 */
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = num; i >= 1; i--) {
			System.out.println();
			for (int y = 1; y <= i; y++) {
				System.out.print("*");
			}
		}
	}
}
