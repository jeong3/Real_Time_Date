package D20240722_wrapper;

public class StringEx01 {

	public static void main(String[] args) {
		// 리터널 : 정수, 실수, 문자, 부울, 문자열
		// 비즈니스 타입: int, double, char, boolean
		// String : 객체
		String str = new String("정지원");//생성자
		String str1 = "정지원";
		String str2 = "정지원";
		if(str1 == str2){ // stack과 stack에 있는 주소값을 비교
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		if(str.equals(str1)){ // stack과 heap에 각각 있는 주소의 값을 비교
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		//모든 객체는 heap영역에 만들어짐 
		//String 의 값은 주소로 저장되는데 객체 생성과는 주소가 다르기 때문에 
		//String 객체와 변수의 주소가 다르기 때문에 값이 다르다
		// str.equals(str1) 
		// 위의 객체 str과 str1의 주소가 아닌 값을 같은지 알아보기 위해서 사용한다.
		
		

	}

}
