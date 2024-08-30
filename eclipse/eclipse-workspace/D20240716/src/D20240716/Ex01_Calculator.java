package D20240716;

public class Ex01_Calculator {
	//멤버 필드는 초기화 시키지 않으면 정수 0 실수 0.0 부울 false 문자열 null 문자 blank 
	//이라는 기본 값을 갖는다.
	private int first = 10;
	private int second = 20;
	private int result;
	
	public Ex01_Calculator() {}
	public Ex01_Calculator(int first , int second) {
		this.first = first; this.second = second;
	}
	
	public void add() {
		result = first + second;
	}
	
	public void print() {
		System.out.println(first);
		System.out.println(second);
		System.out.println(result);
		
	}
}
