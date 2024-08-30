package D20240716;

public class Ex02 {
	//메인 메소드 외에도 사용할 수 있도록 static 을 사용해 밖에서 선언해준다.
	static Ex02_Calculator calc = new Ex02_Calculator();
	static Ex02_Calculator calc1 = new Ex02_Calculator(100, 200);
	
	public static void main(String[] args) {
		calc.add();
		calc.print();
		print();
		calc1.add();
		calc1.print();
	}
	public static void print() {
		System.out.println(calc.getFirst());
		System.out.println(calc.getSecond());
		System.out.println(calc.getResult());
	}
	

}
