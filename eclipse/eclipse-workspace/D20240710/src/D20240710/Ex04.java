package D20240710;

public class Ex04 {

	public static void main(String[] args) {
		// switch case
		char gender = 'M';
		if(gender == 'M') {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}
		switch(gender) {
		// gender == 'M'
		case 'M' : System.out.println("남자");
		break; 
		// gender == 'F'
		case 'F' : System.out.println("여자");
		}
		
		switch(gender) {
		case 'M' : System.out.println("남자");
		break;
		default : System.out.println("여자");
		}
		switch(gender) {
		default : System.out.println("여자");
		break; // default가 먼저와도 상관 X, 하지만 break; 는 맨아래꺼 외에는 모두 필요
		case 'M' : System.out.println("남자");
		}

	}

}
