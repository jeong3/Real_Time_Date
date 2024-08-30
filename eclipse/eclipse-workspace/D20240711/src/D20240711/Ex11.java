package D20240711;

public class Ex11 {

	public static void main(String[] args) {
		// 가변 2차원 배열 : 행의 크기가 일정하지 않을 때
		int i1[] = { 1, 2, 3, 4 };
		int i2[] = { 10, 11 };
		int i3[] = { 11, 21, 31, 41, 51 };
		int ii[][] = new int[3][];
		ii[0] = i1;
		ii[1] = i2;
		ii[2] = i3;
		System.out.println(ii[0][3]);
		System.out.println(ii[1][1]);
		System.out.println(ii[2][4]);
		
		for(int [] row : ii) {
			for(int col : row) {
				System.out.println(col);
			}
		}
		for(int row = 0; row < ii.length; row++) {
			for(int col = 0; col < ii[row].length; col++) { 
				//ii[row].length; 행의 크기를 각각 가져올 수 있다.
				System.out.println(ii[row][col]);
			}
		}

	}

}
