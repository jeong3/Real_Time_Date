package j20240827;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i; //선언
		i = 10; // 대입
		double d = 20.5; //초기화
		/* 리터널 자료형 
		 * 정수 : byte, short, int, long :signed
		 * 실수 : float, double
		 * 문자(정수) : char(unsigned) : 0 ~ 65535 : 2byte (유니코드)
		 * 			 ASCII : 0 ~ 254 : 영어(아스키코드)
		 * 부울 : boolean : true/false
		 * 
		 * */
		boolean bl = true;
		char ch = '숭';
		System.out.println(ch);
		System.out.println((int)ch);
		ch = 49709;
		System.out.println(ch);
		// 형변환
		// 자동형변환 : 작은것에서 큰것으로 바꿀 때
		// byte -> short -> int -> long , 정수 -> 실수
		//                               -> float -> double
		// char는 음수 값을 받지 못하기 때문에(unsigned) byte나 short값을 가져올 수 없다.
		// 강제형변환 : 큰 것에서 작은 것으로 바꿀 때, overflow가 발생하여 값이 달라질 수 있다.
		//
		ch = 65534;
		byte b = (byte)ch; // 강제형변환을 할 때 자료형을 명시해줘야 한다.
		System.out.println(b);
		
		
		
		
		
		
		
		
		//         
	}

}
