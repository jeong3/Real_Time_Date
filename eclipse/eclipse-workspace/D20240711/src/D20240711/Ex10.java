package D20240711;

public class Ex10 {

	public static void main(String[] args) {
		int i1[] = { 1, 2, 3, 4 };
		int i2[] = { 10, 20, 30, 40 };
		int i3[] = { 11, 22, 33, 44 };
		int ii[][] = new int[3][];
		ii[0] = i1;
		ii[1] = i2;
		ii[2] = i3;
		System.out.println(ii[1][2]); // ii[일차원배열 i2][일차원 배열 i2의 2]
		System.out.println(ii[2][3]);

		int ii1[][] = { { 1, 2, 3, 4 }, { 10, 20, 30, 40 }, { 11, 22, 33, 44 } };
		System.out.println(ii1[1][2]);
		
		int ii2[][] = new int[][] {{ 1, 2, 3, 4 }, { 10, 20, 30, 40}, { 11, 22, 33, 44 }};
		System.out.println(ii2[1][3]);
		
		int ii3[][] = new int[2][3];
		ii3[0][0] = 1;
		ii3[1][2] = 2;
		System.out.println(ii3[0][0]);
		//1. 2차원에 1차원 대입
		int j [][] = new int [3][];
		//2.
		int j1[][] = {{1,2},{3,4}};
		//3.
		int j2[][] = new int[][] {{1,2},{3,4}};
		//4.
		int j3[][] = new int [2][3];
		//					  행  열 : 열은 1차원의 크기
		System.out.println(j3.length); // 행의 크기
		System.out.println(j3[0].length); // 열의크기
		
		for(int rowidx = 0; rowidx < j3.length; rowidx++) {
			for(int colidx = 0; colidx <j3[rowidx].length; colidx++) {
				System.out.println(j3[rowidx][colidx]);
			}
		}
		// 2차원 배열의 for each
		for(int row [] : j3) { //1차원배열을 가져온 후 1차원배열 안의 값을 가져와야함 
			for(int col : row) {
				System.out.println(col);
			}
			
		}
		
		
	}

}
