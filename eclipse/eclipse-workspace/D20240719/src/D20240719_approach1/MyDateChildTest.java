package D20240719_approach1;

public class MyDateChildTest {

	public static void main(String[] args) {
		MyDateChild my = new MyDateChild();
		// 다른 패키지에 있는 prodected 멤버는 직접 접근이 불가하다.
		//my.month = 10 
		my.setDay(10);
		
	}

}
