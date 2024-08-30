package D20240710;

public class Ex11 {

	public static void main(String[] args) {
		int y = 1;
		int sum = 0;
		sum = sum + y;
		y++;
		sum = sum + y;
		y++;
		sum = sum + y;
		y++;
		sum = sum + y;
		y++;
		sum = sum + y;
		y++;
		System.out.println(sum);
		y = 1;
		sum = 0;
		sum = sum + y++;
		sum = sum + y++;
		sum = sum + y++;
		sum = sum + y++;
		sum = sum + y++;
		System.out.println(sum);
		sum = 0;
		for(int i = 1; i <= 5; i++) {
			sum = sum + i;
		}
		System.out.println(sum);

	}

}
