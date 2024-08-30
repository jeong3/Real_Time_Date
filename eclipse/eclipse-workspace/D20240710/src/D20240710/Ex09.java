package D20240710;

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		// 구구단
		Scanner sc = new Scanner(System.in);
		System.out.println("단을 입력하세요 :");
		int dan = sc.nextInt();
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan +" x "+ i +" = " + dan * i);
		}

	}

}
