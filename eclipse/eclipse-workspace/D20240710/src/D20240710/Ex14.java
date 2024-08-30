package D20240710;

import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 단 입력: ");
		int startDan = sc.nextInt();
		System.out.print("마지막 단 입력: ");
		int endDan = sc.nextInt();
		System.out.print("시작 곱 입력: ");
		int startGop = sc.nextInt();
		System.out.print("마지막 곱 입력: ");
		int endGop = sc.nextInt();
		for(int dan = startDan; dan <= endDan; dan++) {
			for(int gop = startGop; gop <= endGop; gop++) {
				System.out.println(dan + " x " + gop + " = " + dan * gop);
			}
		}

	}

}
