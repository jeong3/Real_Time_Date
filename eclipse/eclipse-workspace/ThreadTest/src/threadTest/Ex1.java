package threadTest;

public class Ex1 {
	public static void main(String[] args) {
		long beforeTime = System.currentTimeMillis();
		int sum = 0;
		for (int i = 0; i < 300000; i++) {
			sum += i;
		}
		System.out.println(sum);

		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime) / 1000;
		System.out.println("시간차이(s) : " + secDiffTime);
	}
}
