package D20240709;

public class Ex8 {

	public static void main(String[] args) {
		// 증가감 연산자의 선행/후행
		int i = 1;
		i++; // i = i + 1;
		System.out.println(i);
		++i;
		System.out.println(i);
		System.out.println(i = i + 1);
		System.out.println(i++); 
		//System.out.println(i); => i++; 출력 후 더해짐 : 후행
		System.out.println(i);
		System.out.println(++i);
		//i = i + 1 => System.out.println(i); 더해진 후 출력 : 선행
		int result;
		result = i++; // 후행 result = i => i = i + 1;
		System.out.println(result); //6
		System.out.println(i); //7
		result = ++i; // 선행 i = i + 1; => result = i; result와 i의 값이 같다.
		System.out.println(result); //8
		System.out.println(i); //8  
	}

}
