package D20240709;

public class Ex20 {

	public static void main(String[] args) {
		// 8세미만은 미취학아동입니다. 입장료 1000
		// 14세미만 초등학생입니다. 입장료 2000
		// 20세미만 중고등학생입니다. 입장료 2500
		// 그 이상은 일반인입니다 입장료 3000
		int age = 12;
		int charge;
		if (age < 8) {
			charge = 1000;
			System.out.println("미 취학 아동입니다. 입장료 : " + charge);
		} else if(age < 14) {
			charge = 2000;
			System.out.println("초등학생입니다. 입장료 : " + charge);
		} else if(age < 20) {
			charge = 2500;
			System.out.println("중, 고등학생입니다. 입장료 : " + charge);
		} else {
			charge = 3000;
			System.out.println("성인입니다. 입장료 : " + charge);
		}
		
	}

}
