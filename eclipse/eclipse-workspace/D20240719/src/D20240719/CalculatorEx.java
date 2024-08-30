package D20240719;

public class CalculatorEx {

	public static void main(String[] args) {
		Calculator calc = new Calculator(10, 20);
		calc.add(20, 30);
		System.out.println(calc.sub());
		calc.print();
		int sum = CalculatorImp.total(new int[] {1,2,3,4});
		System.out.println(sum); // 리턴은 반환으로 출력이 가능
	}

}
