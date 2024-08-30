package D20240710;

import java.util.Scanner;

public class Ex17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("시작 곱 입력:");
		int startGop = sc.nextInt();
		System.out.println("마지막 곱 입력");
		int endGop = sc.nextInt();
		int gop = startGop;
		while(gop <= endGop) {
			System.out.println("5 x " + gop + " = " + 5 * gop);
			gop++;
		}

	}

}
