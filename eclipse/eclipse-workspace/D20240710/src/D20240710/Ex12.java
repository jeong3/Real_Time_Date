package D20240710;

import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 수를 입력 :");
		int start = sc.nextInt();
		System.out.print("마지막 수를 입력 :");
		int end = sc.nextInt();
		int sum = 0;
		for(int i = start; i <= end; i++) {
			sum = sum + i;
		}
		System.out.println(sum);

	}

}
