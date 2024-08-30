package D20240710;

import java.util.Scanner;

public class Ex18 {

	public static void main(String[] args) {
		//1~100까지 합 구하는 while문
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 수 입력 : ");
		int sum = 0;
		int i = sc.nextInt();
		System.out.print("마지막 수 입력 : ");
		int end = sc.nextInt();
		while(i <= end) {
			sum += i;
			i++;
		}
		System.out.println(sum);

	}

}
