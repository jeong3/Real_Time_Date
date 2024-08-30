package D20240722_wrapper;

public class WrapperEx02 {

	public static void main(String[] args) {
		int i = 10;
		Integer ii = i; // boxing
		i = ii; 		// unboxing
		String str = "100";
		i = Integer.parseInt(str); // 정수형을 문자열 String
		str = Integer.toString(10); // 문자열을 정수형 int
		str = Double.toString(10.5); // 문자열을 실수형 double
		str = Long.toString(1000000000000L); // 문자열을 정수형 long
		

	}

}
