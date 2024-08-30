package D20240709;

public class Ex14 {
	public static void main(String[] args) {
		char gender = 'M';
		if( gender == 'M') {
			System.out.println("남자");
		}else {
			System.out.println("여자");
		}
		int money = 1000; //버스를 타려면 1450원이 필요하다.
		if (money >= 1450) {
			System.out.println("버스를 탄다");
		}else {
			System.out.println("걸어가시오");
		}
		int mat = 80;
		int eng = 40;
		int kor = 70;
		boolean result;
		result = eng >= 40 && mat >= 40 && kor >= 40 && (mat + eng + kor)/3 >=60;
		if (result) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
	}
}
