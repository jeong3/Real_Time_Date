package D20240717;
//                 자식클래스                   부모클래스
public class Ex04_FourCalculator extends Ex04_Calculator {
	// 자식클래스에도 생성자가 필요하기 때문에 생성자를 만들기 위해서는
	// 부모클래스에 생성자가 있다면 자식클래스에서 부모생성자를 실행하도록 해야한다.
	public Ex04_FourCalculator(int first, int second) {
		super(first,second); // super : 부모생성자인 Ex04_Calculator를 말함.
		System.out.println("자식객체");
	}
	
	public void sub() {
		result = first - second;
	}
	public void mul() {
		result = first * second;
	}
}
