package J20240828;



public class Calculator {

	int num1;
	int num2;
	
	public Calculator() {}
	public Calculator(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int add() {
		return num1 + num2;
	}
	public int div() {
		return num1 / num2;
	}
}
