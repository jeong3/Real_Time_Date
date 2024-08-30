package D20240719_1;

public interface CalculatorImp2 extends CalculatorImp1 {
//class가 아닌 interface지만 CalculatorImp1이라는 이름의 인터페이스를 가져와 확장하기 때문에 extends를 사용한다.
	// default 메서드
	default void print() {
		System.out.println("디폴트 메서드");
	}
	
	// static 정적메서드
	static int total(int [] arr) {
		int total = 0;
		for(int i : arr) {
			total += i;
		}
		return total;
	}

	void add(int num1, int num2);

	int sub();
	
	
}
