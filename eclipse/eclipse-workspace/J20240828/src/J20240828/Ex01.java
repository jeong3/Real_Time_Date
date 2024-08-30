package J20240828;

public class Ex01 {

	public static void main(String[] args) {
		char ch[] = new char[26];
		ch[0] = 65;
		ch[1] = 'B';
		
		//대문자
		for (int i = 65; i < ch.length + 65; i++) {
			ch[i - 65] = (char) i;
		}
		for(char val : ch) {
			System.out.println(val);
		}
		//소문자 A + 32
		for(int i = 0; i < ch.length; i++) {
			ch[i] = (char)(i + 97);
		}
		for(char val : ch) {
			System.out.println(val);
		}
		//마지막 요소 출력
		System.out.println(ch[ch.length-1]);
		
		
	}
}
