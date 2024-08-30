package D20240722;

public class CalculatorEx01 {

	public static void main(String[] args) {
		FourCalculatorAbstract ex01 = new FourCalculatorAbstract(10, 20);
		
		//다형성 : 부모클래스인 변수
		CalculatorAbstract ex02 = new FourCalculatorAbstract(10, 20);
		
		
	}
}
