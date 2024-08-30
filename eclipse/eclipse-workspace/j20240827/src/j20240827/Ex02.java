package j20240827;

public class Ex02 {

	public static void main(String[] args) {
		// 연산자
		// 사칙연산자 : +, -, *, / , %
		int i = 10;
		int j = 3;
		int result = i % j;
		System.out.println(result);
		result = i / j;
		System.out.println(result);
		
		//증감연산자 : ++, --
		i = 1;
		i = i + 1;
		i++;//후행
		i = i - 1;
		i--;
		++i;//선행
		--i;
	}

}
