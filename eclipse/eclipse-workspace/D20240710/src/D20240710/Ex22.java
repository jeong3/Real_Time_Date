package D20240710;

public class Ex22 {

	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		while(true) {
			sum += i;
			i++;
			if(i > 100)break;
		}
		System.out.println(sum);
		i = 1;
		sum = 0;
		do {
			sum += i;
			i++;
		}while(i <= 100);
		System.out.println(sum);
	}

}
