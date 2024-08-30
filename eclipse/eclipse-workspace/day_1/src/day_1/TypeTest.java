package day_1;

public class TypeTest {

	public static void main(String[] args) {
		
		//정수형 데이터
		byte b = -128;
		System.out.println(b);
		b = 127;
		System.out.println(b);
		short sh = -32768;
		System.out.println(sh);
		sh = 32767;
		System.out.println(sh);
		int i = -2100000000;
		System.out.println(i);
		i = 2100000000;
		System.out.println(i);
		long l = 100000000;
		System.out.println(l);
		l = 10000000000000L; //int의 크기 약21억을 넘어가는 수가 되면 L을 붙혀준다.
		System.out.println(l);
		
		//실수형 데이터
		float f = 10.6f; //양수일 때 f를 붙혀준다.
		System.out.println(f);
		double d = 10.5;
		System.out.println(d);
		
		//논리형 데이터
		boolean bl = true; //true 또는 false 만 가능
		System.out.println(bl);
		bl = false;
		System.out.println(bl);
		
		//문자
		char ch = 'A'; //문자열이 아닌 문자로 하나, ''를 사용
		System.out.println(ch);
		ch = 65;
		System.out.println(ch);
		ch = '정';
		System.out.println(ch);
		
	}

}
