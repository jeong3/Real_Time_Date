package D20240711;

public class Ex08 {

	public static void main(String[] args) {
		double d [] = new double[3];
		int size = 0;
		d[0] = 10.5;size++;
		d[1] = 20.5;size++;
		d[2] = 30.5;size++;
		for(int idx = 0; idx < size; idx++) {
			System.out.println(d[idx]);
		}
	}

}
