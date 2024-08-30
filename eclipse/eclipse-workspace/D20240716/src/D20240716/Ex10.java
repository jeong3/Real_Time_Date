package D20240716;

public class Ex10 {

	public static void main(String[] args) {
		Ex10_Static.num2 = 20; // static 정적 변수는 클래스명.변수를 이용해 값을 저장 혹은 변경 할 수 있다.
		Ex10_Static s = new Ex10_Static();
		Ex10_Static s1 = new Ex10_Static();
		
		s.num1 = 100;
		s1.num1 = 1000;
		s.num2 = 1000;
		s1.num2 = 1; 
		
		
		System.out.println(s.num1);
		System.out.println(s1.num1);
		
		System.out.println(s.result);
		System.out.println(s1.result);
		
		System.out.println(s.num2);
		System.out.println(s1.num2);
		Ex10_Static.add(10, 10);
	}

}
