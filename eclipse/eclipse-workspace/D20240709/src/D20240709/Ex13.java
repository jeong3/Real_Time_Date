package D20240709;

public class Ex13 {

	public static void main(String[] args) {
		/*
		 * 제어문(조건문, 반복문)
		 * 조건문 : if, switch
		 * 반복문 : for, while, do~while
		 * 	
		 * 	if(조건식){
		 * 		명령어
		 * }
		 * 조건식에는 bool타입인 결과가 오는 식이나 값이어야 한다.
		 * if(true) / if(i > j)
		 * 명령어는 조건식의 결과값이 true일 때 실행할 코드작성
		 * */
		int money = 1000; //버스를 타려면 1450원이 필요하다.
		if (money >= 1450) {
			System.out.println("버스를 탄다");
		}else {
			System.out.println("걸어가시오");
		}
		int age = 8;
		if (age >= 7) {
			System.out.println("학교를 간다.");		
		} //단일 if문
		int eng = 60;
		int kor = 70;
		int mat = 50;
		if(eng >= 60) System.out.println("Pass"); // 한개의 명령어는 중괄호{}없이 가능하다.
		if(kor >= 60) {
			System.out.println("Pass");
		}
		if(mat >= 60) {
			System.out.println("Pass");
		}

	}

}
