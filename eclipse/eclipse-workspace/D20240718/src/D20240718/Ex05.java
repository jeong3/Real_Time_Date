package D20240718;

public class Ex05 {

	public static void main(String[] args) {
		Ex05_FourCalculator ex01 = new Ex05_FourCalculator(10, 20);
		ex01.div();
		System.out.println(ex01.result);
		Ex05_FourCalculator ex02 = new Ex05_FourCalculator(0, 10);
		ex02.div();
		System.out.println(ex02.result);
		Ex05_FourCalculator ex03 = new Ex05_FourCalculator(10, 0);
		ex03.div();
		System.out.println(ex03.result);
		Ex05_Calculator ex04 = new Ex05_Calculator(20, 0);
		//ex04.div(); 
		
	}

}
