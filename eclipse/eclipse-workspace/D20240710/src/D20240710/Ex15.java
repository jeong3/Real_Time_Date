package D20240710;

public class Ex15 {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("나무를"+ i +"번 찍었습니다.");
		}
		
		int i = 1;
		for (; i <= 10;) {
			System.out.println("나무를"+ i +"번 찍었습니다.");
			i++;
		}
		i = 1;
		while(i <= 10) { //for문형식에서 초기화 혹은 대입은 밖에서 먼저 적어주고, 증감식은 안으로 들어간다.
			System.out.println("나무를"+ i +"번 찍었습니다.");
			i++;
		}
	}
}
