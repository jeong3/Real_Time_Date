package D20240709;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		System.out.println(10 + 5);
		int i, j;
		i = 10;
		j = 5;
		System.out.println(i + j);
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 : ");
		int num1 = sc.nextInt(); //숫자입력받기
		//System.out.println("num1" + num1);
		System.out.print("숫자를 입력해주세요 : "); //ln은 줄바꿈
		int num2 = sc.nextInt(); //숫자입력받기
		System.out.println("num1 + num2 = " + (num1 + num2)); //계산값은 우선순위 연산자 ()
	}

}
