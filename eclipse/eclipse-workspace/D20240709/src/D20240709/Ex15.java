package D20240709;

import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		// Scanner를 이용해서 변수
		Scanner sc = new Scanner(System.in);
		System.out.print("수학점수를 입력해주세요 : ");
		int mat = sc.nextInt(); //숫자입력받기
		System.out.print("영어점수를 입력해주세요 : ");
		int eng = sc.nextInt(); //숫자입력받기
		System.out.print("국어점수를 입력해주세요 : ");
		int kor = sc.nextInt(); //숫자입력받기
		boolean result = mat >= 40 && kor >= 40 && eng >= 40 && (mat + eng + kor) / 3 >= 60;
		if(result) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
	}
}
