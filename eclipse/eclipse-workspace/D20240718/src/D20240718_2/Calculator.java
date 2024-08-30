package D20240718_2;

public abstract class Calculator {
	int first;
	int second;
	int result;
	public Calculator(int first, int second) {
		this.first = first;
		this.second = second;
	}
	public void add() {
		result = first + second;
	}
	public abstract void div(); //abstract메서드를 만들기위해서는 abstract클래스가 있어야 한다.
	
	
	
}
