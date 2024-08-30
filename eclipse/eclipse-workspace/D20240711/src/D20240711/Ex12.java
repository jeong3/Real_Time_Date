package D20240711;

public class Ex12 {

	public static void main(String[] args) {
		//1차원 배열 선언
		
		int i [] = {1,2,3,4}; //첫번째 방법
		int i1 [] = new int[] {1,2,3,4};
		int i2 [] = new int[3];
		i2[0] = 1;
		i2[1] = 2;
		i2[2] = 3;
		
		int [] i3; //위의 첫번째 방법 외에는 선언 후 대입 가능
		i3 = new int[] {1,2,3,4};
		System.out.println(i3[0]);
		i3 = new int[4];
		System.out.println(i3[0]);

	}

}
