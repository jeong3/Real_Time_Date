package D20240716;

public class Ex02_1 {

	public static void main(String[] args) {
		Ex02_Calculator calc = new Ex02_Calculator();
		calc.add();
		calc.print();
		Ex02_Calculator calc1 = new Ex02_Calculator(100, 200);
		calc1.add();
		calc1.print();
		test(10,20);
		test(100,200);
		print(calc);
		print(calc1);
	}
	public static void test(int num1 , int num2) {
		System.out.println(num1 + num2);
	}
	public static void print(Ex02_Calculator c) { // 객체 전달 방식 : 객체를 매개 변수로 받는다.
		System.out.println(c.getFirst());
		System.out.println(c.getSecond());
		System.out.println(c.getResult());
	}

}
