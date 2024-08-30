package D20240711;

public class Ex16 {

	public static void main(String[] args) {
		int [][] i1 = new int [2][3];
		i1[0][0] = 10;
		i1[0][1] = 20;
		i1[0][2] = 30;
		i1[1][0] = 40;
		i1[1][1] = 50;
		i1[1][2] = 60;
		
		for(int rowidx = 0; rowidx < i1.length; rowidx++) {
			for(int colidx =0; colidx < i1[rowidx].length; colidx++) {
				i1[rowidx][colidx] = (colidx + 1) * 100;
			}
		}
		for(int [] row : i1) {
			for(int val : row) {
				System.out.println(val);
			}
		}
		
		

	}

}
