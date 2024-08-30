package day_1;

public class CastingTest {

	public static void main(String[] args) {
		byte b = 100;
		int i = -2100000000;
		System.out.println(b);
		System.out.println(i);
		i = b; //byte => int 자동(묵시)적 타입변환 Promotion
		System.out.println(i);
		double d = b; //위와 같이 자동형변환
		System.out.println(d);
		//byte => short => int => long, float / float => double 자동형변환 -> 작은거에서 큰걸로 변환가능
		
		b = (byte)i;
		System.out.println(b);
		i = 128;
		//0000000000000000000000010000000
		b = (byte)i; // 10000000 // -128
		System.out.println(b);
		i = 129;
		//0000000000000000000000010000001
		b = (byte)i; // 10000001 // -128에서 +1 => -127
		System.out.println(b);
		//큰거에서 작은거로 변환 -> 강제(명시)적 타입변환 Casting
	}

}
