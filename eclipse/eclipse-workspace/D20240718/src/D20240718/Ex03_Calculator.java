package D20240718;

public class Ex03_Calculator {
	int first;
	int second;
	int result;

	public Ex03_Calculator(int first, int second) {
		this.first = first;
		this.second = second;
	}
	public void add() {
		result = first + second;
	}
	public void div() {
		result = first / second;
	}
}
