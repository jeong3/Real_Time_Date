package D20240711;

public class Ex07 {

	public static void main(String[] args) {
		char ch [] = {'A','B','C'};
		char ch1 [] = new char[]{'A','B','C'};
		char ch2 [] = new char[3]; //기본값 : "" : blank
		
		for(int idx = 0; idx < ch.length; idx++) {
			ch2[idx] = (char)(idx+65); //소문자는 +32
			System.out.println(ch2[idx]);
		}
		
		char character = 'A';
		for(int idx = 0; idx < ch2.length; idx++,character++) {
			ch2[idx] = character;
			System.out.println(ch2[idx]);
		}
		

	}

}
