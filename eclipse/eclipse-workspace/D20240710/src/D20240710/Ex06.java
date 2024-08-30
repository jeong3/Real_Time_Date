package D20240710;

public class Ex06 {

	public static void main(String[] args) {
		int age = 12;
		int charge;
		
		switch(age) {
		case 1 :
		case 2 :
		case 3 :
		case 4 :
		case 5 :
		case 6 :
		case 7 : System.out.println("미취학아동"); charge = 1000; break;
		case 8 :
		case 9 :
		case 10 :
		case 11 :
		case 12 :
		case 13 :
		case 14 : System.out.println("초등학생"); charge = 2000; break;
		case 15 :
		case 16 :
		case 17 :
		case 18 :
		case 19 : System.out.println("청소년"); charge = 2500; break;
		default : System.out.println("성인"); charge = 3000;
		}
		System.out.println("입장료는 " + charge + "입니다");
		
	}

}
