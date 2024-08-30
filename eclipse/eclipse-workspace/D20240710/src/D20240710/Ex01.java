package D20240710;

public class Ex01 {

	public static void main(String[] args) {
		int i = 10, j = 20;
		String str = i > j ? "크다" : "작다";
		System.out.println(str);
		if(i > j) {
			str = "크다";
		}else {
			str = "작다";
		}
		System.out.println(str);

	}

}
