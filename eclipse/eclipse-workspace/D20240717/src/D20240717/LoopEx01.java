package D20240717;

public class LoopEx01 {

	public static void main(String[] args) {
		System.out.println("나무를 찍었습니다.");
		for(int i = 0; i < 10; i++) {
			System.out.println("나무를 "+(i+1)+"번 찍었습니다.");
		}
		
		int i = 0;
		while(i < 10) {
			System.out.println("나무를 "+(i+1)+"번 찍었습니다.");
			i++;
			
		}
		
		for(int j = 1; j <= 9; j++) {
			System.out.println("6 * "+j+ " = "+ 6 * j);
		}
		int sum = 0;
		for (int j = 1; j <=5; j++) {
			sum = sum + j;
		}
		System.out.println(sum);
	}

}
