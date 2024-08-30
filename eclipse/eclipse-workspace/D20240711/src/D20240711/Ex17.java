package D20240711;

public class Ex17 {

	public static void main(String[] args) {
		int [][] i1 = new int [3][]; // 행 고정 열 가변
		int [] ii1 = {1,2,3};
		int [] ii2 = {4,5};
		int [] ii3 = {6,7,8,9};
		i1[0] = ii1;
		i1[1] = ii2;
		i1[2] = ii3;
		for(int rowidx = 0; rowidx < i1.length; rowidx++) {
			for(int colidx = 0; colidx < i1[rowidx].length; colidx++) {
				System.out.println(i1[rowidx][colidx]);
			}
		}

	}

}
