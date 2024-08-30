package day_1;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello Java");
		//-128 ~ 127
		byte Num; //선언
		Num = 10; //초기화
		System.out.println(Num);
		String Str; //문자열 변수 선언
		Str = "정지원";
		System.out.println(Str);
		//byte 20; -> 변수명이 숫자일 수 없다.
		Num = 20; // 대입
		System.out.println(Num);
		byte a = 30; // 선언과 초기화
		System.out.println(a);
		//논리 (true/false)
		String firstName = "정";
		//String firstName; 에러)변수명은 한번만 선언한다. 대입은 얼마든지 가능
		System.out.println(firstName);
		String firstname; //변수명은 대소문자를 구분한다.
		firstname = "이"; 
		System.out.println(firstname); //초기화를 해야 출력이 가능
		
	}

}
