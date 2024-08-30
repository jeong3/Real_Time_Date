package D20240711;

public class Ex14 {

	public static void main(String[] args) {
		// 2차원 배열
		int [][] i1 = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		// 가변형 2차원 배열
		int [][] i2 = new int[][] {{2,3},{4,5,6},{7,8,9,10}};
		for(int [] z : i2) {
			for(int val: z) {
				System.out.println(val);
				
			}
		}
		System.out.println(i2.length); // 2차원의 크기
		System.out.println(i2[0].length); // [0]의 1차원 크기
		
		for(int idx = 0; idx < i2.length; idx++) {
			for(int val = 0; val < i2[idx].length; val++) {
				System.out.println("i2["+idx+"]["+val+"] = "+i2[idx][val]);
			}
			
		}
		
	}

}
