package J20240828;

import java.util.Arrays;

public class Ex04 {

	public static void main(String[] args) {
		int i1[] = {1,2,3,4,5};
		int i2[];
		i2 = i1;
		System.out.println(Arrays.toString(i1));
		System.out.println(Arrays.toString(i2));
		i2[1] = 200;
		System.out.println(Arrays.toString(i1));
		System.out.println(Arrays.toString(i2));
		int i3 [] = new int [5];
		System.arraycopy(i1, 0, i3, 0, i1.length);
		System.out.println(Arrays.toString(i3));
		i3[1] = 2;
		System.out.println(Arrays.toString(i3));
	}

}
