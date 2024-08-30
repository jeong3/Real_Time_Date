package D20240718;

public class Ex04_Calculator {
	int first;
	int second;
	int result;

	public Ex04_Calculator() {
		first = 10;
		second = 20;
	}
	public Ex04_Calculator(int first, int second) {
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
