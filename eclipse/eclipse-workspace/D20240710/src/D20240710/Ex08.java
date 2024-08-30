package D20240710;

public class Ex08 {

	public static void main(String[] args) {
		// 반복문 : 반복하고자하는 명령문 for, while
		for (int start = 1; start <= 10; start++) {
			System.out.println("나무를 "+ start +"번 찍었습니다.");
		}
		int i = 1;
		for (int start = 0; start <= 10; start++) {
			System.out.println("나무를 "+ i +"번 찍었습니다.");
			i++;
		}
		for (int start = 1, y = 1; start <= 10; start++, y++) { 
			System.out.println("나무를 "+ y +"번 찍었습니다.");
		}// for문 안의 변수는 밖으로 가져 올 수 없다. 반대로 밖의 변수는 가져올 수 있다.
		
		
	}

}
