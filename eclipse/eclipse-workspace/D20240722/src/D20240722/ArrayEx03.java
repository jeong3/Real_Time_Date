package D20240722;

public class ArrayEx03 {

	public static void main(String[] args) {
		// 배열 선언
		// 2차원 : 1차원의 집합체
		String [][] str = new String [2][3];
		// 출력
		System.out.println(str[0][1]);
		// 배열의 크기
		System.out.println(str.length); // 행의 크기
		System.out.println(str[0].length); // 첫번째 열의 크기
		System.out.println(str[1].length); // 두번째 열의 크기
		
		// 전체 출력 for each , for
		for(String s [] : str) {
			for(String val : s) {
				System.out.println(val);
			}
		}
		for(int row = 0; row < str.length; row++) {
			for (int col = 0; col < str[row].length; col++) {
				System.out.println(str[row][col]);
			}
		}

	}

}
