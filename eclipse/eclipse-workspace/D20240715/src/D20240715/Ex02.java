package D20240715;

public class Ex02 {

	public static void main(String[] args) {
		// 변수 : 하나의 값만 저장 가능 , 정해진 타입만 가능
		// 배열 : 하나 이상의 값 저장가능 , 크기가 고정 , 정해진 타입만 저장 가능
		// class : 하나 이상의 값 저장가능, 정해진 타입 외에 여러 타입의 값을 저장 가능
		Ex02_Student st = new Ex02_Student(); //st : class 변수, 객체 변수
		// 			 new Student(); // 객체 생성
		st.name = "정지원";
		st.studentNum = 20191023;
		st.addr = "광명";
		st.age = 24;
		System.out.println(st.name);
		
		Ex02_Student st1 = new Ex02_Student(); 
		st1.name = "정원";
		System.out.println(st1.name);
		//객체 생성을 통해 사용한다 => 객체지향
	}

}
