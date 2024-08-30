package D20240710;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		// 3 4 5월은 봄
		// 6 7 8 여름
		// 9 10 11 가을
		// 12 1 2 겨울
		Scanner sc = new Scanner(System.in);
		int sea = sc.nextInt();
		switch (sea) {
		case 12:
		case 1:
		case 2:
			System.out.println("겨울");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("봄");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("여름");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("가을");
			break;
		default:
			System.out.println("1~12월 중에 고르시오.");
		}

	}
}
