package D20240719;

public interface CalculatorImp { // 생성자가 없다.
	// 상수
	final double PI = 3.141592;
	int ERROR = 99999; // 인터페이스 내에서는 final을 안적어도 상수가 된다.

	// 추상메서드
	void add(int num1, int num2);

	int sub();

	// default 메서드
	default void print() {
		System.out.println("디펄트 메서드");
	}

	// 정적 메서드
	static int total(int [] arr) {
		int total = 0;
		for (int i : arr) {
			total += i;
		}
		return total;
	}

}
