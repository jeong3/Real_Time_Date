package J20240828;

public class Ex10 {

	public static void main(String[] args) {
		Calculator cal = new Calculator(10,20);
		int result = cal.add(); // add()함수의 리턴값을 받기위해선 변수가 있어야한다.
		System.out.println(result);
		result = cal.div();
		System.out.println(result);
		
		FourCalculator cal1 = new FourCalculator(20, 0);
		System.out.println(cal1.add()); //부모의 add메서드
		System.out.println(cal1.mul()); //자식의 mul메서드 둘다 사용가능
		
		cal = cal1;
		result = cal.div();
		System.out.println(result);
		
		
	}

}
