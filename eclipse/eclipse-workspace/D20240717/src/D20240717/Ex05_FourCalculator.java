package D20240717;

public class Ex05_FourCalculator extends Ex05_Calculator {
	
	public Ex05_FourCalculator() {
		super();
	}
	public Ex05_FourCalculator(int first, int second) {
		super(first, second);
	}
	
	public void print() {
		System.out.println(result);
	}
	
	
	public void sub() {
		result = first - second;
	}
	public void mul() {
		result = first * second;
	}
}
