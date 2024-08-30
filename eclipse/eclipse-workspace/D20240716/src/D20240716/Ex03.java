package D20240716;

public class Ex03 {

	public static void main(String[] args) {
		int i = 10; // 정수형 변수
		// 객체변수
		Ex03_Calculator calc = new Ex03_Calculator(10, 20);
		calc.add();
		print(calc);
		Ex03_Calculator calc1 = new Ex03_Calculator(100, 200);
		calc1.add();
		print(calc1);
		Ex03_Calculator calc2 = new Ex03_Calculator(1000, 2000);
		calc2.add();
		print(calc2);
		intMethod(i);
	}
	public static void intMethod(int a) { // 값 전달 방식
		System.out.println(a);
	}
	public static void print(Ex03_Calculator num) { // 객체 전달 방식
		System.out.println(num.getFirst());
		System.out.println(num.getSecond());
		System.out.println(num.getResult());
	}
}
