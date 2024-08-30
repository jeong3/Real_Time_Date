package D20240711;

public class Ex15 {

	public static void main(String[] args) {
		//
		int [][] i1 = {{1,2,3},{4,5,6},{7,8,9}};
		int [][] i2 = {{1,2,3,4},{5,6},{7,8,9}};
		System.out.println(i2.length);
		for(int [] row : i2) {
			for(int col : row) {
				System.out.println(col);
			}
		}
		for(int rowidx = 0; rowidx < i2.length; rowidx++) {
			for(int colidx = 0; colidx < i2[rowidx].length; colidx++) {
				System.out.println(i2[rowidx][colidx]);
			}
		}
		
	}

}
