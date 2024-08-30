package D20240722;

public class FourCalculator extends Calculator {

	public FourCalculator(int first, int second) {
		super(first, second);
		//부모 클래스에 있는 생성자 호출 : super();
	}
	public int sub() {
		return first - second;
	}
	public int mul() {
		return first * second;
	}
	
	// 부모 클래스에서 상속 받은 메서드를 재정의 : 오버라이딩
	@Override
	public int div() {
		if(second == 0)return 0;
		else return first / second;
	}
}
