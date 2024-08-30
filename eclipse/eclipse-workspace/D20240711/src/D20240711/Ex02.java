package D20240711;

public class Ex02 {

	public static void main(String[] args) {
		// 변수 : 한번에 하나의 값을 저장한다.
		// 배열 : 하나의 변수에 여러 값을 저장하도록 만든 것
		// index : 배열의 저장공간의 번호, 0부터 시작한다. 0 1 2 3
		int y[] = { 10, 20, 30, 40 }; // 배열을 통해 y라는 변수에 10,20,30,40의 값을 갖는다.
		System.out.println(y[0]);// 10
		System.out.println(y[1]);// 20
		y[0] = 100; // 배열 안의 값을 변경할 수 있다.
		System.out.println(y[0]);// 100

		// 배열 선언
		// 1. 배열 선언과 초기화
		int j[] = { 1, 2, 3, 4 }; // []는 연산자로 int [] j 로 사용해도 된다. 
		System.out.println(j[3]);//4
		j[3] = 100;
		// 2. 배열 선언과 초기화
		int j1 [] = new int[] {1, 2, 3, 4};
		System.out.println(j1[3]);//4
		j1[3] = 100;
		// 3. 배열 선언 후 초기화
		int j2 [] = new int[4];
		System.out.println(j2[0]); // 선언하게 되면 기본값으로 0을 갖게된다.
		j2[0] = 1;
		j2[1] = 2;
		j2[2] = 3;
		j2[3] = 4;
		System.out.println(j2[0]);
		
		for (int i = 0; i <= 3; i++) {
			System.out.println(j2[i]);
		} 
		// for each : 배열의 값을 출력할 때의 반복문
		for(int i : j2) {
			System.out.println(i);
		}
		
		
	}

}
