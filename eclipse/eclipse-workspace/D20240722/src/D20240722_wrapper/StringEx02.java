package D20240722_wrapper;

public class StringEx02 {

	public static void main(String[] args) {
		String str1 = "정지원"; // stack
		String str2 = new String("정지원"); // heap
		if (str1 == str2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		if(str1.equals(str2)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		//문자열 연결
		String javaStr = "java";
		String androidStr = "android";
		System.out.println(javaStr+androidStr);
		String result = javaStr.concat(androidStr); //concat은 위에 문자를 연결해준 것과 같다.
		System.out.println(result);
		//변수가 저장하고 있는 주소 출력
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		//문자열에서 문자 추출
		System.out.println(androidStr);
		char ch = androidStr.charAt(2);
		System.out.println(ch);
		String subStr = "자바 프로그래밍";
		ch = subStr.charAt(3);
		System.out.println(ch);
		//문자열 자르기
		String st = subStr.substring(3, (3+3));
		System.out.println(st);
		st = subStr.substring(3, 6); // start = 3; start < 6; 프로그
		System.out.println(st);
		st = subStr.substring(3); // start = 3; 마지막까지
		System.out.println(st);
		//크기
		System.out.println(subStr.length());
		//마지막 글자 가져오기
		ch = subStr.charAt(subStr.length() -1);
		System.out.println(ch);
		//문자열에서 문자가 index를 가져오기
		int idx = subStr.indexOf('프');
		System.out.println(idx);
		//'프'부터 3글자 인덱스로 출력
		st = subStr.substring(subStr.indexOf('프'),subStr.indexOf('프')+3);
		System.out.println(st);
		//문자열 변경 "자바 프로그래밍"을 "java 프로그래밍"
		System.out.println(subStr);
		result = subStr.replace("자바", "java");
		//원래의 데이터는 변경되지 않기 때문에 출력하기 위해서 이렇게 사용
		System.out.println(result); 
		//
		String original = "        Java Programming";
		result = original.toUpperCase(); // 모두 대문자
		System.out.println(result);
		result = original.toLowerCase(); // 모두 소문자
		System.out.println(result);
		result = original.trim(); // 공백 없애기
		System.out.println(result);
		
		int i = 10;
		result = String.valueOf(i); // 정수인 i를 문자열로 변환
		System.out.println(result);
		
		
		
		
	}

}
