package D20240710;

public class Ex02 {

	public static void main(String[] args) {
//		제어문(조건문, 반복문)
//		조건문 : if, switch
//		반복문 : for, while, do ~ while
//		 if(조건식){ 조건식에는 bool값이 오거나 결과가 bool인 식이 온다.
//		      명령문 : true일 때 실행할 코드를 작성
//		}단일 if문
//		if ~ else
//		if(조건식) {
//		      명령문 : true일 때 실행할 코드를 작성
//		} else{
//			  명령문 : false일 때 실행할 코드를 작성
//			  명령어_n
//		}
//		
//		
		int money = 1500;
		if(money >= 1450) {
			System.out.println("버스타고가");
		}
		money = 1000;
		if(money >= 1450) {
			System.out.println("버스");
		} else {
			System.out.println("뚜벅이");
		}
		
	}

}
