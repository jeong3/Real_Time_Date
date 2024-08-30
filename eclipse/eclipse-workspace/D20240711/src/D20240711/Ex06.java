package D20240711;

public class Ex06 {

	public static void main(String[] args) {
		char ch[] = new char[26];
		ch[0] = 'A'; //아스키 코드 : 65
		ch[1] = 66;
		System.out.println(ch[0]);
		System.out.println(ch[1]);
		//대문자
		for(int idx = 0; idx < ch.length; idx++) {
			ch[idx] = (char)(idx + 65); //int => char 강제형변환 Casting
		}
		for(char c : ch) {
			System.out.println(c);
		}
		//소문자
		for(int idx = 0; idx < ch.length; idx++) {
			ch[idx] = (char)(idx + 97); //소문자 a는 아스키 코드 97이다.
		}
		for(char c : ch) {
			System.out.println(c);
		}
		
		char character = 'A';
		for(int idx = 0; idx < ch.length; idx++, character++) {
			ch[idx] = character;
			System.out.println(ch[idx]);
		}
		
		
		
		
	}

}
