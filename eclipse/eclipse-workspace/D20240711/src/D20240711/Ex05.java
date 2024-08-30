package D20240711;

public class Ex05 {

	public static void main(String[] args) {
		int i [] = new int[4];
		for(int z : i) { 		// 0
			System.out.println(z);
		}
		double d [] = new double[4];
		for(double z: d) {  	// 0.0
			System.out.println(z);
		}
		boolean bl [] = new boolean[4];
		for(boolean z : bl) { 	// false
			System.out.println(z);
		}
		String str [] = new String[4];
		for(String z : str) { 	// null
			System.out.println(z);
		}
		char ch [] = new char[4];
		for(char z : ch) {   	// blank : System.out.println("");
			System.out.println(z);
		}
	}

}
