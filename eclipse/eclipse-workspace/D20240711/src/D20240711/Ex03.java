package D20240711;

public class Ex03 {

	public static void main(String[] args) {
		// 배열 선언
		// 1.
		double d[] = { 10.0, 20.0, 30.0, 40.0 };
		for(double i : d) { // 10.0 20.0 30.0 40.0
			System.out.println(i);
		}
		
		// 2.
		double d1 [] = new double [] { 10.0, 20.0, 30.0, 40.0 };
		// 3.
		double d2 [] = new double[4]; //[공간] 4개의 공간 0 1 2 3
		//			 {0.0, 0.0, 0.0, 0.0}
		for(double i : d2) {
			System.out.println(i); // 0.0 0.0 0.0 0.0
		}
		System.out.println("배열의 크기 : " + d2.length); // 4
		// 
		for(int idx = 0; idx < d2.length; idx++) {
			d2[idx] = idx + 1;
		}
		for(double i : d2) {
			System.out.println(i);
		}
		
		//
		for(int idx = 0; idx <= d2.length -1; idx++) {
			d2[idx] = idx + 10;
		}
		for(double i : d2) {
			System.out.println(i);
		}
		
	}

}
