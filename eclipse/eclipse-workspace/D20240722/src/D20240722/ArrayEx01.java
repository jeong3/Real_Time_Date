package D20240722;

public class ArrayEx01 {

	public static void main(String[] args) {
		// index : 배열에 있는 요소가 가지는 고유의 번호 : 0부터
		String str [] = new String [] {"정지원", "ㅁㄴㅇㄹ","ㅁㄴㅁㅁㅁ"};
		// 배열의 크기 : 요소의 개수
		System.out.println(str.length);
		
		// 배열 안에 있는 요소의 값 출력 : for each , for
		for(String s : str) {
			System.out.println(s);
		}
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		
		
		
		
	}

}
