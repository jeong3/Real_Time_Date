package D20240718;

public class Ex06_Calculator {
	int first;
	int second;
	int result;

	public Ex06_Calculator(int first, int second) {
		this.first = first;
		this.second = second;
	}
	public void add() {
		result = first + second;
	}
	//메서드에 final 키워드를 준다는 것은 자식 클래스에서 오버라이딩 즉, 재정의를 할 수 없게 할 때 사용한다.
	public final void div() { //final 메서드
		result = first / second;
	}
}
