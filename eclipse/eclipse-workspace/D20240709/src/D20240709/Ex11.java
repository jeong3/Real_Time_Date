package D20240709;

public class Ex11 {

	public static void main(String[] args) {
		// 논리연산자 => 비교연산자와 함께 사용
		boolean i, j, result;
		i = true;
		j = false;
		result = i && j; 
		System.out.println(result); // false
		result = i || j;
		System.out.println(result); // true
		int eng = 60;
		int kor = 70;
		int mat = 40;
		// 적어도 한 과목이 40미만이면 false
		// 평균이 60미만이어도 false
		result = mat < 40 && eng < 40 && kor < 40 && (mat + kor + eng) / 3 < 60;
		System.out.println(result); //true && false = false
		
	}

}
