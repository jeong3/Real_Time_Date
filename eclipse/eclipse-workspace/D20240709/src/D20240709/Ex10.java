package D20240709;

public class Ex10 {

	public static void main(String[] args) {
		// 비교연산자(관계연산자) -> 논리연산자 boolean를 통해 비교할 수 있다.
		// < , > , <= , >= , == , !=(not)
		int i = 10 , j = 20;
		boolean result;
		result = i > j;
		System.out.println(result); //false
		result = i < j;
		System.out.println(result); //true
		j = 10;
		result = i >= j;
		System.out.println(result); //true
		result = i <= j;
		System.out.println(result); //true
		result = i == j;
		System.out.println(result); //true
		result = i != j;
		System.out.println(result); //false
		
		

	}

}
