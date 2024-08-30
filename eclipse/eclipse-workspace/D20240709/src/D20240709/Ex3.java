package D20240709;

public class Ex3 {
	public static void main(String[] args) {
		//형변환 자동
		short s = 10;
		int i = s; // 자동
		byte b = (byte)i; //강제
		/*
		 * 
		 * */
		float f = i;
		System.out.println(f);
		i = (int)f;
		System.out.println(i);
	}
}
