package D20240709;

public class Ex12 {

	public static void main(String[] args) {
		// 4년마다 윤년 , 100년마다는 윤년이 아니다
		// 400년마다는 윤년이다
		int year = 2200;
		boolean yyear ;
		yyear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		System.out.println(yyear);
		String str;
		str = yyear ? "윤년" : "평년"; //삼항연산자(조건연산자)
		System.out.println(str);
		str = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? "윤년" : "평년";
		System.out.println(str);
	}
}
