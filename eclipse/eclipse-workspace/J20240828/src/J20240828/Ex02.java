package J20240828;

public class Ex02 {

	public static void main(String[] args) {
		int i1 = 10;
		int i2 = 20;
		int i3 = 30;
		int [] ii1 = new int [] {i1,i2,i3};
		int ii2 [] = new int [] {100,200,300};
		int ii3 [] = new int [] {1000,2000,3000};
		int i [][] = new int [][] {ii1,ii2,ii3};
		
		
		for(int row = 0; row < i.length; row++) {
			for(int col = 0; col < i[row].length; col++) {
				i[row][col] = 10*(row+1)*(col+1);
			}
		}
		for(int arr [] : i) {
			for(int val : arr) {
				System.out.println(val);
			}
		}
	}

}
