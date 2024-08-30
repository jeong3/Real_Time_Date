package D20240711;

public class Ex20 {

	public static void main(String[] args) {
		int[] i1 = { 1, 2, 3, 4, 5 };
		int[] i2 = i1;
		System.out.println(i1[2]);
		System.out.println(i2[2]);
		i2[2] = 100; //i2[2]만 대입으로 바꿨지만 i1[2]도 같이 바뀜 
		//=> 그래서 배열은 int[] i2 = i1; 이렇게 대입하면 안된다.
		//System.arraycopy(i1, 0, i3, 0, i1.length);를 이용해서 카피 가능
		System.out.println(i1[2]);
		System.out.println(i2[2]);
		int [] i3 = new int[5];
		System.arraycopy(i1, 0, i3, 0, i1.length); //i1[0]에서 i2[0]로 i1.length 만큼 카피한다.
		System.out.println(i1[2]);
		System.out.println(i2[2]);
		i3[2] = 1000;
		System.out.println(i1[2]);
		System.out.println(i3[2]);
		
	}

}
