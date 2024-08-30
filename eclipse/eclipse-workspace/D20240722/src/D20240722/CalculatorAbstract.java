package D20240722;

public abstract class CalculatorAbstract { // 추상 클래스
	int first;
	int second;
	int result;
	
	
	public CalculatorAbstract(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	public int add() {
		return first + second;
	}
	
	public abstract int div(); // 추상메서드
}
