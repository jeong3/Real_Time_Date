package D20240718;

public class Ex02_FourCalculator extends Ex02_Calculator {
	public Ex02_FourCalculator() {
		super(); // 생성자 상속
	}

	public void sub() {
		result = first - second;
	}

	public void mul() {
		result = first * second;
	}

}
