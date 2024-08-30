package D20240709;

import java.util.Scanner;

public class Ex19 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		Scanner sc = new Scanner(System.in);
		System.out.println("1.더하기 | 2.빼기 | 3.곱하기 | 4.나누기 ");
		System.out.println("1부터 4사이의 값을 입력하시오 : ");
		int i = sc.nextInt();
		if(i == 1) {
			System.out.println(num1 + num2);
		} else if(i == 2) {
			System.out.println(num1 - num2);
		} else if(i == 3) {
			System.out.println(num1 * num2);
		} else if(i == 4) {
			System.out.println(num1 / num2);
		} else {
			System.out.println("1부터 4사이의 값을 입력하지 않았습니다.");
			
		}

	}

}
