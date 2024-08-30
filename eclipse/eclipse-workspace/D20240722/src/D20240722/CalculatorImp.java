package D20240722;

public interface CalculatorImp {
	// final 변수 : 상수
	double PI = 3.141592;
	int ERROR = 999;
	
	public int add(); // 추상메서드
	public int sub();
	default void print() {
		System.out.println("디폴트 메서드");
	}
	
	
}
