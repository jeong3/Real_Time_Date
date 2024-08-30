package D20240710;

public class Ex03 {

	public static void main(String[] args) {
		/* 다중 if문 if ~ if ~ else ~ else ~
		 * if ~ else if ~ else
		 * 
		 * 
		 * 
		 * 
		 * */
		int score = 75; //else if문안에 다중if문을 넣을 수 있다.
		if(score >= 90) {
			if(score >= 95) System.out.println("A+");
			else System.out.println("A");
		} else if(score >= 80) {
			if(score >= 85) System.out.println("B+");
			else System.out.println("B");
		} else if(score >= 70) {
			if(score >= 75) System.out.println("C+");
			else System.out.println("C");
		} else if(score >= 60) {
			if(score >= 65) System.out.println("D+");
			else System.out.println("D");
		} else {
			System.out.println("F");
		}
		
		int age = 12;
		int charge;
		if (age >= 20) {
			System.out.println("성인");
			charge = 3000;
		} else if (age >= 14) {
			System.out.println("청소년");
			charge = 2500;
		} else if (age >= 8) {
			System.out.println("초등학생");
			charge = 2000;
		} else {
			System.out.println("미 취학 아동");
			charge = 1000;
		}
		System.out.println("입장료는 " + charge + "입니다");
		
		
	}

}
