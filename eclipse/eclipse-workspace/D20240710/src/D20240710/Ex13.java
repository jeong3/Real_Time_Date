package D20240710;

public class Ex13 {

	public static void main(String[] args) {
		// 반복문은 반복하고자 할 때 명령문을 사용

		for (int gop = 1; gop <= 9; gop++) {
			System.out.println("5 x " + gop + "=" + 5 * gop);
		}
		// 이중반복문
		for (int dan = 5; dan <= 7; dan++) {
			for (int gop = 1; gop <= 9; gop++) {
				System.out.println(dan + " x " + gop + "=" + dan * gop);
			}
		}
	}

}
